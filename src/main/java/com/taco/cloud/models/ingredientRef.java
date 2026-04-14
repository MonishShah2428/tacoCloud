package com.taco.cloud.models;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class ingredientRef {
    private final String ingredientId;
}
