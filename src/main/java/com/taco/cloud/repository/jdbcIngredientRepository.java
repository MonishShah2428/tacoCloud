package com.taco.cloud.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taco.cloud.models.Ingredient;

@Repository
public class jdbcIngredientRepository implements ingredientRepositoryInterface {
    
    private JdbcTemplate jdbc;
    public jdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbc.query(
            "select id, name, type from Ingredient where id=?",
            this::mapRowToIngredient, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
            rs.getString("id"),
            rs.getString("name"),
            Ingredient.Type.valueOf(rs.getString("type")));
    }
    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update(
            "insert into Ingredient (id,name,type) values (?,?,?)",
            ingredient.getId(), ingredient.getName(), ingredient.getType().toString()
        );
        return ingredient;
    }
}
