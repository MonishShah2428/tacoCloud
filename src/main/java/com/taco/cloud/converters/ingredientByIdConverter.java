package com.taco.cloud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.taco.cloud.models.ingredientRef;

@Component
public class ingredientByIdConverter implements Converter<String, ingredientRef> {

    @Override
    public ingredientRef convert(String id) {
        return new ingredientRef(id);
    }
}
 