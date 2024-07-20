package com.webmusical.springboot.backend.apirest.services;

import com.webmusical.springboot.backend.apirest.models.entity.User;
import com.webmusical.springboot.backend.apirest.models.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO save(UserDTO userDTO);
    void delete(Long id);
}
