package com.taco.cloud.messaging.kitchen.listener;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.taco.cloud.models.tacoOrder;

@Component
@Profile("jms-listener")
public class OrderListener {
    private KitchenUI ui;
    
    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(tacoOrder order) {
        ui.displayOrder(order);
    }
}
