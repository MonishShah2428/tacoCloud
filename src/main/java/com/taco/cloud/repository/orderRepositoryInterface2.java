package com.taco.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import com.taco.cloud.models.tacoOrder;
public interface orderRepositoryInterface2 extends CrudRepository<tacoOrder, String> {
    
}

