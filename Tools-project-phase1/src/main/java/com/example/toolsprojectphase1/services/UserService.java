package com.example.toolsprojectphase1.services;
import com.example.toolsprojectphase1.entities.User;
import com.example.toolsprojectphase1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;


@Service
public class UserService {
    @Autowired
    UserRepo userRepo;


    public void createUser(User U){
        userRepo.save(U);
    }

    public User getUser(Long id){
        return userRepo.findById(id).get();
    }

    public void deleteUser(Long id){
        User U = userRepo.findById(id).get();
        userRepo.deleteById(id);
    }

    public void deleteAllUsers(){
        userRepo.deleteAll();
    }

    public ResponseEntity<?> login(User u){
        try{
            if(userRepo.findByUsername(u.getUsername()).get(0).getPassword().equals(u.getPassword())){
                return ResponseEntity.ok().build();
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
            }
        return ResponseEntity.notFound().build();
    }
}
