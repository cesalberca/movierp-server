package com.movierp.server.services;

import com.movierp.server.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductService extends CrudRepository<Product, Long> {
}
