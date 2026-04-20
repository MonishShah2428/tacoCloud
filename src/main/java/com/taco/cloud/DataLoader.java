package com.taco.cloud;

import com.taco.cloud.models.Ingredient;
import com.taco.cloud.models.Ingredient.Type;
import com.taco.cloud.models.taco;
import com.taco.cloud.repository.ingredientRepositoryInterface2;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.taco.cloud.repository.orderRepositoryInterface2;
import com.taco.cloud.repository.tacosRepository;
import com.taco.cloud.security.userRepositoryInterface;
@Component
public class DataLoader implements ApplicationRunner {

    private final orderRepositoryInterface2 orderRepositoryInterface2;
    private final tacosRepository tacosRepository;
    private final ingredientRepositoryInterface2 ingredientRepo;
    private final userRepositoryInterface userRepo;


    public DataLoader(orderRepositoryInterface2 orderRepositoryInterface2, tacosRepository tacosRepository, ingredientRepositoryInterface2 ingredientRepo, userRepositoryInterface userRepo) {
        this.orderRepositoryInterface2 = orderRepositoryInterface2;
        this.tacosRepository = tacosRepository;
        this.ingredientRepo = ingredientRepo;
        this.userRepo = userRepo;
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

        // Create ingredient references
        Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
        Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
        Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
        Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
        Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
        Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
        Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
        Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
        Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
        Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);

        taco taco1 = new taco();
        taco1.setName("Carnivore");
        taco1.setIngredients(Arrays.asList(
        flourTortilla, groundBeef, carnitas,
        sourCream, salsa, cheddar));
        tacosRepository.save(taco1);
        
        taco taco2 = new taco();
        taco2.setName("Bovine Bounty");
        taco2.setIngredients(Arrays.asList(
        cornTortilla, groundBeef, cheddar,
        jack, sourCream));
        tacosRepository.save(taco2);

        taco taco3 = new taco();
        taco3.setName("Veg-Out");
        taco3.setIngredients(Arrays.asList(
        flourTortilla, cornTortilla, tomatoes,
        lettuce, salsa));
        tacosRepository.save(taco3);
    }
}
