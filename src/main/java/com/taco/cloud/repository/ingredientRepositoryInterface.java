package com.taco.cloud.repository;

import java.util.Optional;
import com.taco.cloud.models.Ingredient;

public interface ingredientRepositoryInterface {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
