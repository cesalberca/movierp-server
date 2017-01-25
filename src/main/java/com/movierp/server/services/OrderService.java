package com.movierp.server.services;

import com.movierp.server.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderService extends CrudRepository<Order, Long> {
}
