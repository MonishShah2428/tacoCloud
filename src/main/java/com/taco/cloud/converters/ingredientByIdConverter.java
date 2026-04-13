package com.taco.cloud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.taco.cloud.models.Ingredient;
import com.taco.cloud.repository.ingredientRepository;
@Component
public class ingredientByIdConverter implements Converter<String, Ingredient> {
    private final ingredientRepository ingredientRepo;
    public ingredientByIdConverter(ingredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepo.findById(id).orElse(null);
    }
}
