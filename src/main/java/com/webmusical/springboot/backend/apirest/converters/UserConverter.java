package com.webmusical.springboot.backend.apirest.converters;

import com.webmusical.springboot.backend.apirest.models.entity.User;
import com.webmusical.springboot.backend.apirest.models.dto.UserDTO;

public class UserConverter {

    public static UserDTO entityToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
//        dto.setCreateAt(user.getCreateAt());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User dtoToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
//        user.setCreateAt(dto.getCreateAt());
        user.setEmail(dto.getEmail());
        return user;
    }
}