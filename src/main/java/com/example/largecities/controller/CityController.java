package com.example.largecities.controller;

import com.example.largecities.models.City;
import com.example.largecities.service.TsvFileService;
import com.example.largecities.utils.CityComparator;
import com.example.largecities.utils.StrScoreMatching;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/suggestion")
    public ResponseEntity<List<City>> suggestedCities(
            @RequestParam(required = true) String q
    ) {
        List<City> cities = tsvFileService.readAndParseTsvFile();
        List<City> filteredCities = new ArrayList<>();

        for (City city : cities) {
            double currentScore = StrScoreMatching.calculateStrMatch(city.getName(), q);
            if (currentScore > 0.5) {
                city.setScore(currentScore);
                filteredCities.add(city);
            }
        }
        filteredCities.sort(new CityComparator());

        return ResponseEntity.ok(filteredCities);
    }

}
