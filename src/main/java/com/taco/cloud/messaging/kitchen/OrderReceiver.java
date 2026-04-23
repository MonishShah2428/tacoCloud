package com.taco.cloud.messaging.kitchen;

import com.taco.cloud.models.tacoOrder;

public interface OrderReceiver {
    tacoOrder receiveOrder();
}
