package com.example.largecities.controller;

import com.example.largecities.models.City;
import com.example.largecities.responsehandler.ResponseHandler;
import com.example.largecities.service.TsvFileService;
import com.example.largecities.utils.CityComparator;
import com.example.largecities.utils.ScoreMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {
    private final TsvFileService tsvFileService;
    private final float SCORE_THRESHOLD = 0.51f;

    @Autowired
    public CityController(TsvFileService tsvFileService) {
        this.tsvFileService = tsvFileService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listCities() {
        List<City> cities = tsvFileService.readAndParseTsvFile();
        if (!cities.isEmpty())
            return ResponseHandler.generateResponse("Success", cities, HttpStatus.OK);

        return ResponseHandler.generateResponse("Not found", cities, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/suggestions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> suggestedCities(
            @RequestParam(required = true) String city_name,
            @RequestParam(required = false) Double lat,
            @RequestParam(required = false) Double lon) {
        City paramCity = new City(city_name, lat, lon);

        List<City> cities = tsvFileService.readAndParseTsvFile();
        List<City> filteredCities = new ArrayList<>();

        for (City city : cities) {
            float currentScore = ScoreMatching.calculateScore(city, paramCity);
            if (currentScore > SCORE_THRESHOLD) {
                city.setScore(currentScore);
                filteredCities.add(city);
            }
        }
        filteredCities.sort(new CityComparator());

        if (!filteredCities.isEmpty())
            return ResponseHandler.generateResponse("Success", filteredCities, HttpStatus.OK);

        return ResponseHandler.generateResponse("Not found suggestions", filteredCities, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/search_by_country", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getByCountry(
            @RequestParam(required = true) String country_code) {
        List<City> cities = tsvFileService.readAndParseTsvFile();
        List<City> fromCountry = new ArrayList<>();

        for (City city : cities) {
            float score = ScoreMatching.calculateStrMatch(city.getCountry(), country_code);
            if (score > SCORE_THRESHOLD) {
                city.setScore(score);
                fromCountry.add(city);
            }
        }

        fromCountry.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        if (!fromCountry.isEmpty())
            return ResponseHandler.generateResponse("Success", fromCountry, HttpStatus.OK);

        return ResponseHandler.generateResponse("Not found cities in " + country_code, fromCountry,
                HttpStatus.NOT_FOUND);
    }
}
