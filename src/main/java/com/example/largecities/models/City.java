package com.example.largecities.models;

import com.univocity.parsers.annotations.Parsed;
import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Parsed(field = "ascii")
    private String name;
    @Parsed(field = "lat")
    private double latitude;
    @Parsed(field = "long")
    private double longitude;
    @Column(name = "score")
    private double score;

    // Getters and setters
    public String getName() { return  this.name; }
    public void setName(String name) { this.name = name; }

    public double getLatitude() { return  this.latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return  this.longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getScore() { return this.score; }

    public  void setScore(double score) { this.score = score; }
}

