package com.apiAggregator.apiAggregator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiAggregator.apiAggregator.dto.WikipediaResponse;
import com.apiAggregator.apiAggregator.service.AggregatorService;

@RestController
public class WikipediaController {

    private final AggregatorService aggregatorService;

    public WikipediaController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/api/wiki")
    public WikipediaResponse getWiki(@RequestParam String city) {
        return aggregatorService.getCitySummary(city);
    }

}
