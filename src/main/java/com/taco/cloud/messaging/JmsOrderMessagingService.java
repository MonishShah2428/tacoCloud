package com.taco.cloud.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jms.core.MessageCreator;
import com.taco.cloud.models.tacoOrder;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Session;
@Service
public class JmsOrderMessagingService implements OrderMessagingService {
    private JmsTemplate jms;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendOrder(tacoOrder order) {
        jms.send(new MessageCreator(){
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage(order);
                message.setStringProperty("X_ORDER_SOURCE", "WEB");
                return message;
            }
        });
    }
}
