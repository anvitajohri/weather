package com.weather.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@EnableConfigurationProperties(ApplicationProperties.class)
public class ApplicationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    public void testPropertiesConfiguration() {
        String apiKey = "your-api-key";
        String weatherApiBaseUrl = "https://api.weather.com";

        assertEquals(apiKey, properties.getApiKey());
        assertEquals(weatherApiBaseUrl, properties.getWeatherApiBaseUrl());
    }

    @Test
    public void testToString() {
        String apiKey = "your-api-key";
        String weatherApiBaseUrl = "https://api.weather.com";

        properties.setApiKey(apiKey);
        properties.setWeatherApiBaseUrl(weatherApiBaseUrl);

        String expectedToString = "ApplicationProperties{" +
                "apiKey='" + apiKey + '\'' +
                ", weatherApiBaseUrl='" + weatherApiBaseUrl + '\'' +
                '}';

        assertEquals(expectedToString, properties.toString());
    }
}