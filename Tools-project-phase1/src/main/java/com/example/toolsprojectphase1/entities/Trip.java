package com.example.toolsprojectphase1.entities;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="StationXTrip",
            joinColumns = @JoinColumn(name="trip_id"),
            inverseJoinColumns = @JoinColumn(name="station_id"))
    private Set<Station> stations;

    @OneToOne
    private Station from_station;

    @OneToOne
    private Station to_station;
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public Station getFrom_station() {
        return from_station;
    }

    public void setFrom_station(Station from_station) {
        this.from_station = from_station;
    }

    public Station getTo_station() {
        return to_station;
    }

    public void setTo_station(Station to_station) {
        this.to_station = to_station;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }
}