package com.webmusical.springboot.backend.apirest.services;

import com.webmusical.springboot.backend.apirest.models.entity.UserAuth;
import com.webmusical.springboot.backend.apirest.models.dto.UserAuthDTO;

import java.util.List;

public interface UserAuthService {
    List<UserAuthDTO> findAll();
    UserAuthDTO findById(Long id);
    UserAuthDTO save(UserAuthDTO userAuthDTO);
    void delete(Long id);
}