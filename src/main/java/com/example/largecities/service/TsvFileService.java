package com.example.largecities.service;

import com.example.largecities.models.City;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class TsvFileService {

    @Autowired
    private ResourceLoader resourceLoader;


    public List<City> readAndParseTsvFile() {
        List<City> parsedRows = null;
        try {
            Resource resource = resourceLoader.getResource("classpath:cities_canada-usa.tsv");

            InputStreamReader inputReader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8);
            BeanListProcessor<City> rowProcessor = new BeanListProcessor<City>(City.class);
            TsvParserSettings settings = new TsvParserSettings();
            settings.setHeaderExtractionEnabled(true);
            settings.setProcessor(rowProcessor);
            TsvParser parser = new TsvParser(settings);
            parser.parse(inputReader);
            return rowProcessor.getBeans();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return parsedRows;
    }
}
