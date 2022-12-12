package com.example.toolsprojectphase1.repositories;

import com.example.toolsprojectphase1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Long> {
    @Query("SELECT u from User u WHERE u.username = :name")
    List<User> findByUsername(@Param("name") String name);
}
