package com.apiAggregator.apiAggregator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiAggregator.apiAggregator.dto.WeatherResponse;
import com.apiAggregator.apiAggregator.service.AggregatorService;

@RestController
public class WeatherController {

    private final AggregatorService aggregatorService;

    public WeatherController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/api/weather")
    public WeatherResponse getWeather(@RequestParam String city) {
        return aggregatorService.getWeatherForCity(city);
    }
}
