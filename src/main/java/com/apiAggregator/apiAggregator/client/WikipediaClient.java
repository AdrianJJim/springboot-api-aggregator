package com.apiAggregator.apiAggregator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.apiAggregator.apiAggregator.config.FeignConfig;

@FeignClient(name = "WikipediaClient", url = "https://en.wikipedia.org/api/rest_v1/page", configuration = FeignConfig.class)
public interface WikipediaClient {

    @GetMapping("/summary/{city}")
    String getCitySummary(@PathVariable("city") String city);
}
