package com.webmusical.springboot.backend.apirest.converters;

import com.webmusical.springboot.backend.apirest.models.entity.UserAuth;
import com.webmusical.springboot.backend.apirest.models.dto.UserAuthDTO;

public class UserAuthConverter {

    public static UserAuthDTO entityToDTO(UserAuth userAuth) {
        UserAuthDTO dto = new UserAuthDTO();
        dto.setId(userAuth.getId());
        dto.setUserName(userAuth.getUserName());
        dto.setPassword(userAuth.getPassword());
        return dto;
    }

    public static UserAuth dtoToEntity(UserAuthDTO dto) {
        UserAuth userAuth = new UserAuth();
        userAuth.setId(dto.getId());
        userAuth.setUserName(dto.getUserName());
        userAuth.setPassword(dto.getPassword());
        return userAuth;
    }
}
