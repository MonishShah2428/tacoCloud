package com.taco.cloud.messaging.kitchen.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.taco.cloud.models.tacoOrder;


@Component
public class OrderListener {
    private KitchenUI kitchenUI;

    public OrderListener(KitchenUI kitchenUI) {
        this.kitchenUI = kitchenUI;
    }

    @RabbitListener(queues = "tacocloud.order")
    public void receiveOrder(tacoOrder order) {
        kitchenUI.displayOrder(order);
    }
}
