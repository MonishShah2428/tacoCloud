/* */
package com.taco.cloud.repository;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taco.cloud.models.ingredientRef;
import com.taco.cloud.models.taco;
import com.taco.cloud.models.tacoOrder;

@Repository
public class jdbcOrderRepository implements orderRepositoryInterface {
    private JdbcOperations jdbcOperations;

    public jdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    @Override
    @Transactional
    public tacoOrder save(tacoOrder order){
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
            "insert into taco_order (delivery_name, delivery_street, delivery_city, delivery_state, delivery_zip, cc_number, cc_expiration, cc_cvv) values (?,?,?,?,?,?,?,?)",
            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR
        );
        pscf.setReturnGeneratedKeys(true);

        order.setPlacedAt(new Date());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
            Arrays.asList(
                order.getDeliveryName(),
                order.getDeliveryStreet(),
                order.getDeliveryCity(),
                order.getDeliveryState(),
                order.getDeliveryZip(),
                order.getCcNumber(),
                order.getCcExpiration(),
                order.getCcCVV()
            )   
        );
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<taco> tacos = order.getTacos();
        int i=0;
        for(taco taco : tacos){
            saveTaco(orderId, i++, taco);
        }
        return order;
    }
    private long saveTaco(Long orderId, int orderKey, taco taco) {
        taco.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf =new PreparedStatementCreatorFactory(
            "insert into Taco "
            + "(name, created_at, taco_order, taco_order_key) "
            + "values (?, ?, ?, ?)",
            Types.VARCHAR, Types.TIMESTAMP, Types.BIGINT, Types.BIGINT
        );
        pscf.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc =
        pscf.newPreparedStatementCreator(
            Arrays.asList(
                taco.getName(),
                taco.getCreatedAt(),
                orderId,
                orderKey
            )
        );
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        taco.setId(tacoId);
        saveIngredientRefs(tacoId, taco.getIngredients());
        return tacoId;
    }
    private void saveIngredientRefs(long tacoId, List<ingredientRef> ingredientRefs) {
        int key = 0;
        for (ingredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(
                "insert into Taco_Ingredients (taco, ingredient, taco_key) values (?, ?, ?)",
                tacoId, ingredientRef.getIngredientId(), key++
            );
        }
    }
}
