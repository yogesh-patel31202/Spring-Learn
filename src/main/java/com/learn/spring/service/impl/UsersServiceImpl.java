package com.learn.spring.service.impl;

import com.learn.spring.entity.Users;
import com.learn.spring.model.response.GenerateResponse;
import com.learn.spring.repository.UsersRepository;
import com.learn.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public ResponseEntity<?> createUser(Users user) {
        GenerateResponse<Users> response = new GenerateResponse<>("User created successfully", usersRepository.save(user));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateUser(Users user) {
        if(usersRepository.existsById(user.getId())){
            GenerateResponse<Users> response = new GenerateResponse<>("User update successfully", usersRepository.save(user));
            return new ResponseEntity<>(response ,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("User not exists" ,HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<?> getAll() {
        GenerateResponse<List<Users>> response = new GenerateResponse<>("User update successfully", usersRepository.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        if(usersRepository.existsById(id)) {
            GenerateResponse<Optional<Users>> response = new GenerateResponse<>("User update successfully", usersRepository.findById(id));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            GenerateResponse<Optional<Users>> response = new GenerateResponse<>("User not update", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<GenerateResponse<?>> changeStatus(Long id) {
        // Check if user exists by id
        if(usersRepository.existsById(id)){
            Users user = usersRepository.findById(id).orElse(null);
            if (user != null) {
                // Toggle the status
                user.setStatus(!user.getStatus());
                usersRepository.save(user);
                // Return the updated user with HTTP 200 OK
                GenerateResponse<?> response = new GenerateResponse<>("User status update successfully");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
        GenerateResponse<?> response = new GenerateResponse<>("User status not update");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
