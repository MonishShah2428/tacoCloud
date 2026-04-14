package com.taco.cloud.repository;


import java.util.Optional;
import com.taco.cloud.models.tacoOrder;

public interface orderRepositoryInterface {
    tacoOrder save(tacoOrder order);  
}
