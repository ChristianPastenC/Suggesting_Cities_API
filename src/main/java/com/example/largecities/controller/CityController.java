package com.example.largecities.controller;

import com.example.largecities.models.City;
import com.example.largecities.service.TsvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class CityController {

    @Autowired
    private TsvFileService tsvFileService;

    @GetMapping("/suggestions")
    public ResponseEntity<List<City>> listCities() {
        List<City> cities = tsvFileService.readAndParseTsvFile();
        return ResponseEntity.ok(cities);
    }
}
