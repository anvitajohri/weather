package com.weather.models;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HistoricalWeatherTest {

    private HistoricalWeather historicalWeather;

    @BeforeEach
    public void setUp() {
        historicalWeather = new HistoricalWeather();
    }

    @Test
    public void testId() {
        assertNull(historicalWeather.getId());
    }

    @Test
    public void testLatitude() {
        Double latitude = 37.7749;
        historicalWeather.setLatitude(latitude);
        assertEquals(latitude, historicalWeather.getLatitude());
    }

    @Test
    public void testLongitude() {
        Double longitude = -122.4194;
        historicalWeather.setLongitude(longitude);
        assertEquals(longitude, historicalWeather.getLongitude());
    }

    @Test
    public void testTimestamp() {
        LocalDateTime timestamp = LocalDateTime.now();
        historicalWeather.setTimestamp(timestamp);
        assertEquals(timestamp, historicalWeather.getTimestamp());
    }

    @Test
    public void testWeatherConditions() {
        String weatherConditions = "Sunny";
        historicalWeather.setWeatherConditions(weatherConditions);
        assertEquals(weatherConditions, historicalWeather.getWeatherConditions());
    }
}