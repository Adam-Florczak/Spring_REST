package com.github.adamflorczak.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.adamflorczak.model.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class WeatherApiController {

    RestTemplate restTemplate = new RestTemplate();
    final String URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    final String API_KEY = "&APPID=60e865cd2970c2077fdba7774d5524d6&id=2172797&units=metric";

    @RequestMapping("/api/weather/{city}")
    public String getWeatherEntity(@PathVariable String city) throws IOException {


        ResponseEntity<String> response = restTemplate.getForEntity(URL + city + API_KEY, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode temperature = root.path("main").path("temp");

        return "Current temperature in " + city + " " + temperature.toString() + " Celcius Grad";
    }

}
