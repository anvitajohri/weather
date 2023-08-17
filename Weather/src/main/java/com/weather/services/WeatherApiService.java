package com.weather.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.weather.models.WeatherData;

@Service
public class WeatherApiService {

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    private final RestTemplate restTemplate;

    public WeatherApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(Double latitude, Double longitude) {
        String apiUrl = weatherApiUrl + "?lat=" + latitude + "&lon=" + longitude;

        WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);

        return weatherData;
    }

}