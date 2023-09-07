package com.example.largecities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class TsvFileService {

    @Autowired
    private ResourceLoader resourceLoader;

    public String readTsvFile() {
        try {
            // Load the TSV file from the resources folder
            Resource resource = resourceLoader.getResource("classpath:cities_canada-usa.tsv");

            // Open an input stream to read the file
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());

            // Read the file using a BufferedReader
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Close the readers
            reader.close();
            inputStreamReader.close();

            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading TSV file: " + e.getMessage();
        }
    }
}
