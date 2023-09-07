package com.example.largecities.models;

import com.univocity.parsers.annotations.Parsed;
import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Parsed(field = "name")
    private String name;
    @Parsed(field = "country")
    private String country;
    @Parsed(field = "lat")
    private double latitude;
    @Parsed(field = "long")
    private double longitude;

    @Parsed(field = "asciiname")
    private String asciiName;

    @Parsed(field = "alternatenames")
    private String alternate_name;

    @Parsed(field = "feature class")
    private char feature_class;

    @Parsed(field = "feature code")
    private String feature_code;

    @Parsed(field = "country code")
    private String country_code;

    @Parsed(field = "cc2")
    private String altcountry_code;

    @Parsed(field = "admin1 code")
    private String fips_code;

    @Parsed(field = "for display")
    private String for_display;

    @Parsed(field = "admin2 code")
    private String sec_code;

    @Parsed(field = "admin3 code")
    private String third_code;

    @Parsed(field = "admin4 code")
    private String fourth_code;

    @Parsed(field = "population")
    private int population;

    @Parsed(field = "elevation")
    private int elevation;

    @Parsed(field = "dem")
    private int dem;

    @Parsed(field = "timezone")
    private String timeZone;

    @Parsed(field = "modification date")
    private String up_date;


    // Getters and setters
    public String getName() { return  this.name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return  this.country; }
    public void setCountry(String country) { this.country = country; }

    public double getLatitude() { return  this.latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return  this.longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getAsciiName() {
        return asciiName;
    }

    public void setAsciiName(String asciiName) {
        this.asciiName = asciiName;
    }

    public String getAlternateName() {
        return alternate_name;
    }

    public void setAlternateName(String alternate_name) {
        this.alternate_name = alternate_name;
    }

    public char getFeatureClass() {
        return feature_class;
    }

    public void setFeatureClass(char feature_class) {
        this.feature_class = feature_class;
    }

    public String getFeatureCode() {
        return feature_code;
    }

    public void setFeatureCode(String feature_code) {
        this.feature_code = feature_code;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountryCode(String country_code) {
        this.country_code = country_code;
    }

    public String getAltCountryCode() {
        return altcountry_code;
    }

    public void setAltCountryCode(String altcountry_code) {
        this.altcountry_code = altcountry_code;
    }

    public String getFipsCode() {
        return fips_code;
    }

    public void setFipsCode(String fips_code) {
        this.fips_code = fips_code;
    }

    public String getNameCode() {
        return for_display;
    }

    public void setNameCode(String for_display) {
        this.for_display = for_display;
    }

    public String getSecCode() {
        return sec_code;
    }

    public void setSecCode(String sec_code) {
        this.sec_code = sec_code;
    }

    public String getThirdCode() {
        return third_code;
    }

    public void setThirdCode(String third_code) {
        this.third_code = third_code;
    }

    public String getFourthCode() {
        return fourth_code;
    }

    public void setFourthCode(String fourth_code) {
        this.fourth_code = fourth_code;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public int getDem() {
        return dem;
    }

    public void setDem(int dem) {
        this.dem = dem;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getUp_date() {
        return up_date;
    }

    public void setUp_date(String up_date) {
        this.up_date = up_date;
    }
}

