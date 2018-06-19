package com.github.adamflorczak.weathermap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Map;

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

    @RequestMapping("/api/weatherobject/{city}")
    public String getWeatherObject(@PathVariable String city){

        Weather weather = restTemplate.getForObject(URL + city + API_KEY, Weather.class);



        return weather.getWeather().toString();
    }

}
