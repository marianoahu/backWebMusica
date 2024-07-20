package com.webmusical.springboot.backend.apirest.repositories;

import com.webmusical.springboot.backend.apirest.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
