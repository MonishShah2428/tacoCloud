package com.taco.cloud.messaging.kitchen;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.taco.cloud.models.tacoOrder;

@Component
public class RabbitOrderReceiver implements OrderReceiver {
    private RabbitTemplate rabbitTemplate;
    private MessageConverter messageConverter;

    public RabbitOrderReceiver(RabbitTemplate rabbitTemplate, MessageConverter messageConverter) {
        this.rabbitTemplate = rabbitTemplate;
        this.messageConverter = messageConverter;
    }

    public tacoOrder receiveOrder() {
        Message message = rabbitTemplate.receive("tacocloud.order");
        if (message != null) {
            return (tacoOrder) messageConverter.fromMessage(message);
        }
        return null;
    }
}
