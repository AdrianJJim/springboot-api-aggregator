package com.apiAggregator.apiAggregator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "${api.weather.url}")
public interface WeatherClient {

    @GetMapping("/current.json")
    String getCurrentWeather(
            @RequestParam("key") String apiKey,
            //"q" is the parameter expected by the API for the city name
            @RequestParam("q") String city
    );
}
