package com.example.largecities.utils;

import com.example.largecities.models.City;

import java.util.Comparator;
public class CityComparator implements Comparator<City> {
    @Override
    public int compare(City cityA, City cityB) {
        return Double.compare(cityB.getScore(), cityA.getScore());
    }
}
