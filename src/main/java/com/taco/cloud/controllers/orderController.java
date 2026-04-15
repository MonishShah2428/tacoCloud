package com.taco.cloud.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.slf4j.Slf4j;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;

import com.taco.cloud.models.tacoOrder;
import com.taco.cloud.repository.orderRepositoryInterface2;
import com.taco.cloud.security.User;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class orderController {
    orderRepositoryInterface2 orderRepo;
    public orderController(orderRepositoryInterface2 orderRepo) {
        this.orderRepo = orderRepo;
    }
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid @ModelAttribute tacoOrder TacoOrder, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("Processing order: " + TacoOrder);
        orderRepo.save(TacoOrder);
        TacoOrder.setUserId(user.getId());
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
