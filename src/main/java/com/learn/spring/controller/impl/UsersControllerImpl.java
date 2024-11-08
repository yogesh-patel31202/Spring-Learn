package com.learn.spring.controller.impl;
import com.learn.spring.controller.UsersController;
import com.learn.spring.entity.Users;
import com.learn.spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersControllerImpl implements UsersController {

    @Autowired
    UsersService usersService;

    @Override
    public ResponseEntity<?> createUser(Users user) {
        try{
            return usersService.createUser(user);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal server error.......", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getUserById(Long id) {
        try{
            return usersService.getById(id);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal server error.......", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getAll() {
        try{
            return usersService.getAll();
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal server error.......", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateUser(Users user) {
        try{
            return usersService.updateUser(user);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal server error.......", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> changeStatus(Long id) {
        try{
            return usersService.changeStatus(id);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Internal server error.......", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
