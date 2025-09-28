package com.apiAggregator.apiAggregator.dto;

import java.util.List;

public class AggregatorResponse {

    private WeatherResponse weather;
    private List<NewsResponse.Article> news;
    private WikipediaResponse wiki;

    public AggregatorResponse(WeatherResponse weather, List<NewsResponse.Article> news, WikipediaResponse wiki) {
        this.weather = weather;
        this.news = news;
        this.wiki = wiki;
    }

    public WeatherResponse getWeather() {
        return weather;
    }

    public List<NewsResponse.Article> getNews() {
        return news;
    }

    public WikipediaResponse getWiki() {
        return wiki;
    }
}
