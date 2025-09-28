package com.apiAggregator.apiAggregator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiAggregator.apiAggregator.dto.NewsResponse;
import com.apiAggregator.apiAggregator.service.AggregatorService;

@RestController
public class NewsController {

    private final AggregatorService aggregatorService;

    public NewsController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/api/news")
    public NewsResponse getNews(@RequestParam String city) {
        return aggregatorService.getNewsForCity(city);
    }

}
