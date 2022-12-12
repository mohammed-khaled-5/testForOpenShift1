package com.example.toolsprojectphase1.repositories;

import com.example.toolsprojectphase1.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository<Trip, Long> {
}
