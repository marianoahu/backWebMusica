package com.webmusical.springboot.backend.apirest.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.webmusical.springboot.backend.apirest.models.entity.UserAuth;
import com.webmusical.springboot.backend.apirest.models.dto.UserAuthDTO;
import com.webmusical.springboot.backend.apirest.repositories.UserAuthRepository;
import com.webmusical.springboot.backend.apirest.services.UserAuthService;
import com.webmusical.springboot.backend.apirest.converters.UserAuthConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public List<UserAuthDTO> findAll() {
        List<UserAuth> userAuth = userAuthRepository.findAll();
        return userAuth.stream()
                .map(UserAuthConverter::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserAuthDTO findById(Long id) {
        UserAuth userAuth = userAuthRepository.findById(id).orElse(null);
        return UserAuthConverter.entityToDTO(userAuth);
    }

    @Override
    public UserAuthDTO save(UserAuthDTO userAuthDTO) {
        UserAuth userAuth = UserAuthConverter.dtoToEntity(userAuthDTO);
        try { //testing if json arrives correctly to back // it does not
            // Crear una instancia de ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Convertir el objeto a JSON
            String json = objectMapper.writeValueAsString(userAuth);

            // Imprimir el JSON en la consola
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();

        }
        userAuth = userAuthRepository.save(userAuth);
        return UserAuthConverter.entityToDTO(userAuth);
    }

    @Override
    public void delete(Long id) {
        userAuthRepository.deleteById(id);
    }
}
