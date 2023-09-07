package com.example.largecities.controller;

import com.example.largecities.service.TsvFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tsv")
public class TsvController {

    @Autowired
    private TsvFileService tsvFileService;

    @GetMapping("/read")
    public ResponseEntity<String> readTsvFile() {
        String tsvFileContent = tsvFileService.readTsvFile();
        return ResponseEntity.ok(tsvFileContent);
    }
}
