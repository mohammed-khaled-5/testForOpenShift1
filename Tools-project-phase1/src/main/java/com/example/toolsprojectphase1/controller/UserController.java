package com.example.toolsprojectphase1.controller;

import com.example.toolsprojectphase1.entities.User;
import com.example.toolsprojectphase1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userservice;

    @PostMapping("/create")
    public void createUser(@RequestBody User u1){
        userservice.createUser(u1);
    }

    @GetMapping("/get/{id}")
    public User getUserById(Long id){
        return userservice.getUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(Long id){
        userservice.deleteUser(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAllUsers(){
        userservice.deleteAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User u) {
        try{
            if(userservice.login(u).getStatusCode().is2xxSuccessful()){
                return ResponseEntity.ok().build();
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }
}
