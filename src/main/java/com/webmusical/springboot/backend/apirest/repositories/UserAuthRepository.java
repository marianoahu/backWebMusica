package com.webmusical.springboot.backend.apirest.repositories;

import com.webmusical.springboot.backend.apirest.models.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
}