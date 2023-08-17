package com.weather.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDataTest {

    @Test
    public void testGettersAndSetters() {
        Double temperature = 25.5;
        String description = "Clear sky";
        Double humidity = 0.65;
        Double windSpeed = 10.0;

        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature(temperature);
        weatherData.setDescription(description);
        weatherData.setHumidity(humidity);
        weatherData.setWindSpeed(windSpeed);

        assertEquals(temperature, weatherData.getTemperature());
        assertEquals(description, weatherData.getDescription());
        assertEquals(humidity, weatherData.getHumidity());
        assertEquals(windSpeed, weatherData.getWindSpeed());
    }

    @Test
    public void testToString() {
        Double temperature = 25.5;
        String description = "Clear sky";
        Double humidity = 0.65;
        Double windSpeed = 10.0;

        WeatherData weatherData = new WeatherData(temperature, description, humidity, windSpeed);
        String expectedToString = "WeatherData{" +
                "temperature=" + temperature +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                '}';
        
        assertEquals(expectedToString, weatherData.toString());
    }
}