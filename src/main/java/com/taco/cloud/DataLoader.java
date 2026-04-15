package com.taco.cloud;

import com.taco.cloud.models.Ingredient;
import com.taco.cloud.models.Ingredient.Type;
import com.taco.cloud.repository.ingredientRepositoryInterface2;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final ingredientRepositoryInterface2 ingredientRepo;

    public DataLoader(ingredientRepositoryInterface2 ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (ingredientRepo.count() == 0) {
            ingredientRepo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            ingredientRepo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            ingredientRepo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            ingredientRepo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            ingredientRepo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            ingredientRepo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            ingredientRepo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            ingredientRepo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            ingredientRepo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            ingredientRepo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        }
    }
}
