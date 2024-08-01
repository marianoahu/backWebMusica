package com.webmusical.springboot.backend.apirest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.webmusical.springboot.backend.apirest.converters.UserConverter;
import com.webmusical.springboot.backend.apirest.models.dto.UserDTO;
import com.webmusical.springboot.backend.apirest.models.entity.User;
import com.webmusical.springboot.backend.apirest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200") // URL de tu frontend Angular
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO newUserDTO = userService.save(userDTO);
        try {
            // Crear una instancia de ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Convertir el objeto a JSON
            String json = objectMapper.writeValueAsString(userDTO);

            // Imprimir el JSON en la consola
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsuarios() {
        List<UserDTO> usuarios = userService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }



    // Otros métodos para listar, actualizar y eliminar usuarios
}

