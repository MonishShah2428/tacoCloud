package com.taco.cloud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.taco.cloud.models.taco;

public interface tacosRepository extends MongoRepository<taco, String> {
}
