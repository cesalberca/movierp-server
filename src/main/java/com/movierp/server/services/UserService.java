package com.movierp.server.services;

import com.movierp.server.entities.ClientesEntity;
import com.movierp.server.entities.UsuariosEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserService extends CrudRepository<UsuariosEntity, Long> {
}
