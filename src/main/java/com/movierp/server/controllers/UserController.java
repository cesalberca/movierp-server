package com.movierp.server.controllers;

import com.movierp.server.entities.UsuariosEntity;
import com.movierp.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<UsuariosEntity>> findAll() {
        Collection<UsuariosEntity> usuarios = (Collection<UsuariosEntity>) this.userService.findAll();

        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsuariosEntity> findOne(@PathVariable("id") Long id) {
        UsuariosEntity usuariosEntity = this.userService.findOne(id);
        return new ResponseEntity<>(usuariosEntity, HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UsuariosEntity> create(@RequestBody UsuariosEntity usuariosEntity) {
        this.userService.save(usuariosEntity);
        return new ResponseEntity<>(usuariosEntity, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UsuariosEntity> update(@PathVariable("id") Long id, @RequestBody UsuariosEntity usuariosEntity) {
        UsuariosEntity currentUser = this.userService.findOne(id);

        if (currentUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.userService.save(currentUser);

        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UsuariosEntity> delete(@PathVariable("id") Long id) {
        UsuariosEntity user = this.userService.findOne(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
