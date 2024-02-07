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

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

    @Autowired
    private TsvFileService tsvFileService;

    @GetMapping("/all")
    public ResponseEntity<List<City>> listCities() {
        List<City> cities = tsvFileService.readAndParseTsvFile();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/suggestions")
    public ResponseEntity<Object> suggestedCities(
            @RequestParam(required = true) String city_name,
            @RequestParam(required = false) Double lat,
            @RequestParam(required = false) Double lon
    ) {
        City paramCity = new City(city_name, lat, lon);

        List<City> cities = tsvFileService.readAndParseTsvFile();
        List<City> filteredCities = new ArrayList<>();

        for (City city : cities) {
            float currentScore = ScoreMatching.calculateScore(city, paramCity);
            if (currentScore > 0.51) {
                city.setScore(currentScore);
                filteredCities.add(city);
            }
        }
        filteredCities.sort(new CityComparator());

        if (!filteredCities.isEmpty()) {
            return ResponseHandler.generateResponse("Success", filteredCities, HttpStatus.OK);
        }

        return ResponseHandler.generateResponse("Not found suggestions", filteredCities, HttpStatus.OK);
    }

}
