package com.taco.cloud.controllers;

import com.taco.cloud.repository.ingredientRepositoryInterface;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import com.taco.cloud.models.Ingredient;
import com.taco.cloud.models.Ingredient.Type;
import com.taco.cloud.models.taco;
import com.taco.cloud.models.tacoOrder;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class designTacoController {

    private final ingredientRepositoryInterface ingredientRepo;
    public designTacoController(ingredientRepositoryInterface ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        // Convert the Iterable to a List for easier processing
        List<Ingredient> ingredientsList = StreamSupport.stream(ingredients.spliterator(), false).collect(Collectors.toList());

        Type[] types = Ingredient.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientsList, type));
        }
    }
    @ModelAttribute(name = "tacoOrder")
    public tacoOrder order() {
        return new tacoOrder();
    }

    @ModelAttribute(name = "taco")
    public taco taco() {
        return new taco();
    }
    @GetMapping
    public String showDesignForm() {
        return "design";
    }
    private Iterable<Ingredient> filterByType(
    List<Ingredient> ingredients, Type type) {
        return ingredients
        .stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
    }
    @PostMapping
    public String processTaco(@Valid taco Taco, Errors errors, @ModelAttribute tacoOrder TacoOrder){
        if(errors.hasErrors()){
            return "design";
        }
        TacoOrder.addTaco(Taco);
        log.info("Processing taco: " + Taco);
        return "redirect:/orders/current";
    }
}
