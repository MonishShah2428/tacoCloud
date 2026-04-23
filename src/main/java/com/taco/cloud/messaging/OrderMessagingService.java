package com.taco.cloud.messaging;

import com.taco.cloud.models.tacoOrder;

public interface OrderMessagingService {
    void sendOrder(tacoOrder order);
}