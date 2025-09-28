package com.apiAggregator.apiAggregator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.apiAggregator.apiAggregator.client.NewsClient;
import com.apiAggregator.apiAggregator.client.WeatherClient;
import com.apiAggregator.apiAggregator.client.WikipediaClient;
import com.apiAggregator.apiAggregator.dto.AggregatorResponse;
import com.apiAggregator.apiAggregator.dto.NewsResponse;
import com.apiAggregator.apiAggregator.dto.WeatherResponse;
import com.apiAggregator.apiAggregator.dto.WikipediaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AggregatorService {

    private final WeatherClient weatherClient;
    private final NewsClient newsClient;
    private final WikipediaClient wikipediaClient;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(AggregatorService.class);

    @Value("${api.weather.key}")
    private String weatherApiKey;

    @Value("${api.news.key}")
    private String newsApiKey;

    public AggregatorService(WeatherClient weatherClient, NewsClient newsClient, WikipediaClient wikipediaClient) {
        this.weatherClient = weatherClient;
        this.newsClient = newsClient;
        this.wikipediaClient = wikipediaClient;
    }

    //Gets data from the Weather API
    public WeatherResponse getWeatherForCity(String city) {
        try {
            String json = weatherClient.getCurrentWeather(weatherApiKey, city);
            WeatherResponse weatherResponse = objectMapper.readValue(json, WeatherResponse.class);
            return weatherResponse;
        } catch (Exception e) {
            logger.error("Error obtaining the weather of the city " + city, e);
            return null;
        }
    }

    //Gets data from the News API
    public NewsResponse getNewsForCity(String city) {
        try {
            String json = newsClient.getTopHeadlines(newsApiKey, city);
            NewsResponse newsResponse = objectMapper.readValue(json, NewsResponse.class);
            return newsResponse;
        } catch (Exception e) {
            logger.error("Error obtaining the weather of the city " + city, e);
            return null;
        }
    }

    //Gets data from the wikipedia API
    public WikipediaResponse getCitySummary(String city) {
        try {
            String json = wikipediaClient.getCitySummary(city);
            WikipediaResponse wikipediaResponse = objectMapper.readValue(json, WikipediaResponse.class);
            return wikipediaResponse;
        } catch (Exception e) {
            logger.error("Error obtaining the weather of the city " + city, e);
            return null;
        }
    }

    //Unites the data from all the APIs into one
    public AggregatorResponse aggregateCityData(String city) {
        try {
            // Data from Weather API
            String weatherJson = weatherClient.getCurrentWeather(weatherApiKey, city);
            WeatherResponse weather = objectMapper.readValue(weatherJson, WeatherResponse.class);

            // Data from News API
            String newsJson = newsClient.getTopHeadlines(newsApiKey, city);
            NewsResponse news = objectMapper.readValue(newsJson, NewsResponse.class);

            // Data from wikipedia API
            String wikiJson = wikipediaClient.getCitySummary(city.trim());
            WikipediaResponse wiki = objectMapper.readValue(wikiJson, WikipediaResponse.class);

            return new AggregatorResponse(weather, news.getArticles(), wiki);

        } catch (Exception e) {
            throw new RuntimeException("Error aggregating data for city " + city, e);
        }
    }

}
