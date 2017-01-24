package com.movierp.server.controllers;

import com.movierp.server.entities.EmpleadosEntity;
import com.movierp.server.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<EmpleadosEntity>> findAll() {
        Collection<EmpleadosEntity> employees = (Collection<EmpleadosEntity>) this.employeeService.findAll();

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmpleadosEntity> findOne(@PathVariable("id") Long id) {
        EmpleadosEntity employee = this.employeeService.findOne(id);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }
}
