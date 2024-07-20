package com.webmusical.springboot.backend.apirest.services.impl;

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
        user = userRepository.save(user);
        return UserConverter.entityToDTO(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}