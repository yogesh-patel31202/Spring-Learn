package com.learn.spring.service;

import com.learn.spring.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface UsersService {

    ResponseEntity<?> createUser(Users user);

    ResponseEntity<?> updateUser(Users user);

    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(Long id);

    ResponseEntity<?> changeStatus(Long id);
}
