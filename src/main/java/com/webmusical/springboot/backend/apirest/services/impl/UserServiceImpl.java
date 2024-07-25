package com.webmusical.springboot.backend.apirest.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.webmusical.springboot.backend.apirest.models.entity.User;
import com.webmusical.springboot.backend.apirest.models.dto.UserDTO;
import com.webmusical.springboot.backend.apirest.repositories.UserRepository;
import com.webmusical.springboot.backend.apirest.services.UserService;
import com.webmusical.springboot.backend.apirest.converters.UserConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserConverter::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return UserConverter.entityToDTO(user);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = UserConverter.dtoToEntity(userDTO);
        try { //testing if json arrives correctly to back // it does not
        // Crear una instancia de ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Convertir el objeto a JSON
        String json = objectMapper.writeValueAsString(user);

        // Imprimir el JSON en la consola
        System.out.println(json);
    } catch (Exception e) {
        e.printStackTrace();

}
        user = userRepository.save(user);
        return UserConverter.entityToDTO(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}