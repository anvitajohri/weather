package com.weather.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.weather.exceptions.WeatherNotFoundException;
import com.weather.models.WeatherData;

@Service
public class WeatherCache {

    @SuppressWarnings("unused")
	@Cacheable("weatherCache")
    public WeatherData getWeatherData(Double latitude, Double longitude) {
        // Simulate fetching weather data from an external API
        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature(25.0);
        weatherData.setDescription("Sunny");
        
        if (weatherData == null) {
            throw new WeatherNotFoundException("Weather data not found for the given coordinates.");
        }

        return weatherData;
    }

    @CacheEvict(value = "weatherCache", allEntries = true)
    public void evictCache() {
        // This method can be used to clear the cache if needed
    }
}