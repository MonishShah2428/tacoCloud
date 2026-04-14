package com.taco.cloud.repository;


import org.springframework.data.repository.CrudRepository;

import com.taco.cloud.models.Ingredient;

public interface ingredientRepositoryInterface extends CrudRepository<Ingredient, String> {

}
