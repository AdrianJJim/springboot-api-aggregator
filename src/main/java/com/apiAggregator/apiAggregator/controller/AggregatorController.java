package com.apiAggregator.apiAggregator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiAggregator.apiAggregator.dto.AggregatorResponse;
import com.apiAggregator.apiAggregator.service.AggregatorService;

@RestController
@RequestMapping("/api")
public class AggregatorController {

    private final AggregatorService aggregatorService;

    public AggregatorController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/aggregate")
    public AggregatorResponse getAgregatedData(@RequestParam String city) {
        return aggregatorService.aggregateCityData(city);
    }

}
