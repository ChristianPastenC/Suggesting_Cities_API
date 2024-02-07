package com.example.largecities.models;

import com.univocity.parsers.annotations.Parsed;
import jakarta.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Parsed(field = "name")
    private String name;

    @Parsed(field = "lat")
    private double latitude;

    @Parsed(field = "lon")
    private double longitude;

    @Parsed(field = "pop")
    private int population;
    
    @Parsed(field = "country")
    private String code_country;

    @Column(name = "score")
    private double score;

    public City() {
    }

    public City(String name, Double latitude, Double longitude) {
        this.latitude = (latitude != null) ? latitude : 0.0;
        this.longitude = (longitude != null) ? longitude : 0.0;
        this.name = (name != null) ? name : "";
    }

    // Getters and setters
    public String getName() {
        if (this.name != null) {
            return this.name;
        }
        return "";
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getPopulation() {
        return this.population;
    }
    
    public void setPopulation(int population) {
        this.population = population;
    }
    
    public String getCountry() {
        return this.code_country;
    }
    
    public void setCountry(String country) {
        this.code_country = country;
    }
}
