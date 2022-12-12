package com.example.toolsprojectphase1.repositories;

import com.example.toolsprojectphase1.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StationRepo extends JpaRepository<Station , Long> {
}
