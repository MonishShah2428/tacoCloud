package com.taco.cloud.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.annotation.Generated;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class taco {
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;
    @NotNull(message="You must choose at least 1 ingredient")
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<ingredientRef> ingredients;
    private Long id;
    private Date createdAt = new Date();
}
