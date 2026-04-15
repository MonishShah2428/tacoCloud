package com.taco.cloud.security;

import org.springframework.data.repository.CrudRepository;
public interface userRepositoryInterface extends CrudRepository<User,String> {
    User findByUsername(String username);
}
