package com.learn.spring.controller;

import com.learn.spring.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public interface UsersController {

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody Users user);

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id);

    @GetMapping()
    public ResponseEntity<?> getAll();

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody Users user);

    @PutMapping("/changeStatus/{id}")
    public ResponseEntity<?> changeStatus(@PathVariable Long id);

}
