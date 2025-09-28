package com.apiAggregator.apiAggregator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "newsClient", url = "${api.news.url}")
public interface NewsClient {

    @GetMapping("/v2/top-headlines")
    String getTopHeadlines(
            @RequestParam("apiKey") String apiKey,
            //"q" is the parameter expected by the API for the city name
            @RequestParam("q") String city
    );
}
