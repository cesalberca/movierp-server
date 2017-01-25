package com.movierp.server.services;


import com.movierp.server.entities.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "sales", path = "sales")
public interface SaleService extends CrudRepository<Sales, Long> {
}
