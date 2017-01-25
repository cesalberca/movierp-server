package com.movierp.server.services;

import com.movierp.server.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserService extends CrudRepository<User, Long> {
}
