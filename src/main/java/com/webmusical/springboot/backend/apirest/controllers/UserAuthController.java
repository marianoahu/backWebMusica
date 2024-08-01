package com.webmusical.springboot.backend.apirest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.webmusical.springboot.backend.apirest.converters.UserAuthConverter;
import com.webmusical.springboot.backend.apirest.models.dto.UserAuthDTO;
import com.webmusical.springboot.backend.apirest.models.entity.UserAuth;
import com.webmusical.springboot.backend.apirest.services.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models/user-auth")
@CrossOrigin(origins = "http://localhost:4200") // URL frontend Angular
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    public UserAuthController(UserAuthService userService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping
    public ResponseEntity<UserAuthDTO> createUserAuth(@RequestBody UserAuthDTO userAuthDTO) {
        UserAuthDTO newUserAuthDTO = userAuthService.save(userAuthDTO);
        try {
            // Crear una instancia de ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Convertir el objeto a JSON
            String json = objectMapper.writeValueAsString(userAuthDTO);

            // Imprimir el JSON en la consola
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>(newUserAuthDTO, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<UserAuthDTO>> getAllUsuarios() {
        List<UserAuthDTO> userAuth = userAuthService.findAll();
        return new ResponseEntity<>(userAuth, HttpStatus.OK);
    }



    // Otros métodos para listar, actualizar y eliminar usuarios
}


