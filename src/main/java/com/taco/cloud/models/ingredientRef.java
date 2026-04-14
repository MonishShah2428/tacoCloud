package com.taco.cloud.models;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("ingredient_ref")
public class ingredientRef {
    private final String ingredientId;
}
