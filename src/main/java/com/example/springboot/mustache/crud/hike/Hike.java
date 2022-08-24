package com.example.springboot.mustache.crud.hike;

import javax.persistence.*;

@Entity
@Table
public class Hike {

    @Id
    @SequenceGenerator(
            name = "hike_sequence",
            sequenceName = "hike_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hike_sequence"
    )
    private Long id;
    @Column(nullable=false)
    private String name;
    private String distance;
    private String elevationGain;

    public Hike() {
    }

    public Hike(Long id, String name, String distance, String elevationGain) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.elevationGain = elevationGain;
    }

    public Hike(String name, String distance, String elevationGain) {
        this.name = name;
        this.distance = distance;
        this.elevationGain = elevationGain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getElevationGain() {
        return elevationGain;
    }

    public void setElevationGain(String elevationGain) {
        this.elevationGain = elevationGain;
    }

    @Override
    public String toString() {
        return "Hike{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", elevationGain=" + elevationGain +
                '}';
    }
}
