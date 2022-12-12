package com.example.toolsprojectphase1.controller;

import com.example.toolsprojectphase1.entities.Station;
import com.example.toolsprojectphase1.services.StationService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/station")
@CrossOrigin("*")
public class StationController {
    @Autowired
    StationService stationservice;

    @PostMapping("/create")
    public void createStation(@RequestBody Station s) {
        stationservice.createStation(s);
    }
    @GetMapping("/get/{id}")
    public Station getStationById(@PathVariable Long id) {
        return stationservice.getStation(id);

    }
    @GetMapping("/getall")
    public List<Station> getAllStations() {
        return stationservice.getAllStations();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStation(@PathVariable Long id) {
        try{
            stationservice.deleteStation(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.ok().body("Station is used in a trip and can not be deleted");
        }
    }
    @DeleteMapping("/deleteall")
    public void deleteAllStations() {
        stationservice.deleteAllStations();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> editStationById(@RequestBody Station s , @PathVariable Long id) {
        try{
            if(stationservice.getStation(id)!=null){
                s.setId(id);
                stationservice.editStationById(s);
                return ResponseEntity.ok().build();}
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
