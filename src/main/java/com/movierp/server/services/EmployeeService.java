package com.movierp.server.services;

import com.movierp.server.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeService extends CrudRepository<Employee, Long> {
}
