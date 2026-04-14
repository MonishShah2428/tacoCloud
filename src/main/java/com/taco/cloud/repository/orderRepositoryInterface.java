package com.taco.cloud.repository;


import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.taco.cloud.models.tacoOrder;

public interface orderRepositoryInterface extends CrudRepository<tacoOrder, UUID> {
}
