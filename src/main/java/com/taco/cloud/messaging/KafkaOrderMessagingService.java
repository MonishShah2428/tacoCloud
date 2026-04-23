package com.taco.cloud.messaging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.taco.cloud.models.tacoOrder;


@Service
public class KafkaOrderMessagingService implements OrderMessagingService {
    private KafkaTemplate<String, tacoOrder> kafka;
    @Autowired
    public KafkaOrderMessagingService(KafkaTemplate<String, tacoOrder> kafka) {
        this.kafka = kafka;
    }

    public void sendOrder(tacoOrder order) {

        kafka.send("tacocloud.order", order);
    }
}
