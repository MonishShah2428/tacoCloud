package com.taco.cloud.messaging.kitchen.listener;

import org.springframework.stereotype.Component;

import com.taco.cloud.models.taco;
import com.taco.cloud.models.tacoOrder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KitchenUI {

    public void displayOrder(tacoOrder order) {
        log.info("============ ORDER RECEIVED ============");
        log.info("Deliver to: {}", order.getDeliveryName());
        log.info("Address: {}, {}, {} {}",
            order.getDeliveryStreet(),
            order.getDeliveryCity(),
            order.getDeliveryState(),
            order.getDeliveryZip());
        log.info("----------------------------------------");
        for (taco taco : order.getTacos()) {
            log.info("  Taco: {}", taco.getName());
            taco.getIngredients().forEach(i -> log.info("    - {}", i.getName()));
        }
        log.info("========================================");
    }
}
