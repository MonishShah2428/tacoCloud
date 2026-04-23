package com.taco.cloud.messaging;

import jakarta.jms.JMSException;
import jakarta.jms.Message;

public interface MessagePostProcessor {
    public Message postProcessMessage(Message message) throws JMSException;
}
