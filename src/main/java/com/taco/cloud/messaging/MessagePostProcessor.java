package com.taco.cloud.messaging;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;

public interface MessagePostProcessor {
    public Message postProcessMessage(Message message) throws AmqpException;
}
