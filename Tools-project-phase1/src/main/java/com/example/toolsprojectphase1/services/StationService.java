package com.example.toolsprojectphase1.services;

import com.example.toolsprojectphase1.entities.Station;
import com.example.toolsprojectphase1.repositories.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    @Autowired
    StationRepo StationRepo;

    public void createStation(Station s){
        StationRepo.save(s);
    }

    public Station getStation(Long id){
        return StationRepo.findById(id).get();
    }

    public List<Station> getAllStations(){
        return StationRepo.findAll();
    }

    public void deleteStation(Long id){
            StationRepo.deleteById(id);
    }

    public void deleteAllStations(){
        StationRepo.deleteAll();
    }

    public void editStationById(Station s){
        StationRepo.save(s);
    }


}
