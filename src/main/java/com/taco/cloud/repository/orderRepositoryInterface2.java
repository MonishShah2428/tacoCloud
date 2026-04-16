package com.taco.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import com.taco.cloud.models.tacoOrder;
import java.util.List;

public interface orderRepositoryInterface2 extends CrudRepository<tacoOrder, String> {
    List<tacoOrder> findByUserIdOrderByPlacedAtDesc(String userId);
}

