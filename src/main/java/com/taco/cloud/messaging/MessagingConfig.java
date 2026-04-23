package com.taco.cloud.messaging;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.JacksonJsonMessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.taco.cloud.models.tacoOrder;

@Configuration
public class MessagingConfig {

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        JacksonJsonMessageConverter converter = new JacksonJsonMessageConverter();
        converter.setTypeIdPropertyName("_typeId");
        converter.setTypeIdMappings(Map.of("order", tacoOrder.class));
        return converter;
    }
}