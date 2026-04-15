package com.taco.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import com.taco.cloud.models.User;
public interface userRepositoryInterface extends CrudRepository<User,String> {
    User findByUsername(String username);
}
