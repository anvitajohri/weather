package com.weather.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

    private String apiKey;
    private String weatherApiBaseUrl;

    // Getters and Setters
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getWeatherApiBaseUrl() {
        return weatherApiBaseUrl;
    }

    public void setWeatherApiBaseUrl(String weatherApiBaseUrl) {
        this.weatherApiBaseUrl = weatherApiBaseUrl;
    }

    // Add more getters and setters for additional properties

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "apiKey='" + apiKey + '\'' +
                ", weatherApiBaseUrl='" + weatherApiBaseUrl + '\'' +
                '}';
    }
}