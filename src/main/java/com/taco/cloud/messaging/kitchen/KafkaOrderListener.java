package com.taco.cloud.messaging.kitchen;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.taco.cloud.messaging.kitchen.listener.KitchenUI;
import com.taco.cloud.models.tacoOrder;


@Component
public class KafkaOrderListener {
    private KitchenUI kitchenUI;

    public KafkaOrderListener(KitchenUI kitchenUI) {
        this.kitchenUI = kitchenUI;
    }

    @KafkaListener(topics = "tacocloud.order")
    public void receiveOrder(tacoOrder order) {
        kitchenUI.displayOrder(order);
    }
}
