package com.example.toolsprojectphase1.controller;

import com.example.toolsprojectphase1.entities.Trip;
import com.example.toolsprojectphase1.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trip")
@CrossOrigin("*")
public class TripController {
    @Autowired
    TripService tripservice;

    @PostMapping("/create")
    public ResponseEntity<?> createTrip(@RequestBody Trip T) {
        try {
            tripservice.createTrip(T);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripservice.getTrip(id);

    }

    @GetMapping("/getall")
    public List<Trip> getAllTrips() {
        return tripservice.getAllTrips();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTrip(@PathVariable Long id) {
        tripservice.deleteTrip(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAllTrips() {
        tripservice.deleteAllTrips();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> editTripById(@RequestBody Trip T, @PathVariable Long id) {
        try {
            if (tripservice.getTrip(id) != null) {
                T.setId(id);
                tripservice.editTripById(T);
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
