package com.example.largecities.models;

import com.univocity.parsers.annotations.Parsed;
import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Parsed(field = "ascii")
    private String ascii;

    @Parsed(field = "id")
    private String geoId;

    private String name;
    @Parsed(field = "lat")
    private double latitude;
    @Parsed(field = "long")
    private double longitude;
    @Column(name = "score")
    private double score;

    public City(){ }
    public City(String name, Double latitude, Double longitude) {
        this.name = (name != null) ? name : "";
        this.latitude = (latitude != null) ? latitude : 0.0;
        this.longitude = (longitude != null) ? longitude : 0.0;
    }

    // Getters and setters
    public String getName() {
        if(this.ascii != null && this.geoId != null)
            return  this.ascii + ", " + this.geoId;
        return this.name;
    }
    public void setName(String name) { this.name = name; }

    public double getLatitude() { return  this.latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return  this.longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getScore() { return this.score; }

    public  void setScore(double score) { this.score = score; }

    protected String getGeoId() { return this.geoId; }

    protected void setGeoId(String geoId) { this.geoId = geoId; }

    protected String getAscii() { return this.ascii; }
    protected void setAscii(String ascii) { this.ascii = ascii; }
}

