package com.taco.cloud.messaging;

import org.apache.kafka.common.KafkaException;
import org.apache.kafka.shaded.com.google.protobuf.Message;


public interface MessagePostProcessor {
    public Message postProcessMessage(Message message) throws KafkaException;
}
