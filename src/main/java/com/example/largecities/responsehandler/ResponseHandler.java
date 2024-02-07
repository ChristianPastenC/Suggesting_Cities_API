package com.example.largecities.responsehandler;

import com.example.largecities.models.City;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, List<City> data, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", data);
        map.put("message", message);
        map.put("data_size", data.size() > 0 ? data.size() - 1 : 0);

        return new ResponseEntity<Object>(map, status);
    }
}
