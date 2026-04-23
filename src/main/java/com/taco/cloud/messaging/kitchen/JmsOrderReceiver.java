package com.taco.cloud.messaging.kitchen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.taco.cloud.models.tacoOrder;

import jakarta.jms.Message;

@Component
public class JmsOrderReceiver implements OrderReceiver {
    private JmsTemplate jms;
    private MessageConverter converter;

    @Autowired
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter) {
        this.jms = jms;
        this.converter = converter;
    }

    public tacoOrder receiveOrder() {
        return (tacoOrder) jms.receiveAndConvert();
    }

}
