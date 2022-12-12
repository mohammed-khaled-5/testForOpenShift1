package com.example.toolsprojectphase1.services;

import com.example.toolsprojectphase1.entities.Trip;
import com.example.toolsprojectphase1.repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    TripRepo TripRepo;

    public void createTrip(Trip T) {
        TripRepo.save(T);
    }

    public Trip getTrip(Long id) {
        return TripRepo.findById(id).get();
    }

    public List<Trip> getAllTrips() {
        return TripRepo.findAll();
    }

    public void deleteTrip(Long id) {
        TripRepo.deleteById(id);
    }

    public void deleteAllTrips() {
        TripRepo.deleteAll();
    }

    public void editTripById(Trip T) {
        TripRepo.save(T);
    }
}
