package com.movierp.server.services;

import com.movierp.server.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderService extends CrudRepository<Order, Long> {
}
