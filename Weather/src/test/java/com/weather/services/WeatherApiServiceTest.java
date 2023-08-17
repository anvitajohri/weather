package com.weather.services;

import com.weather.models.WeatherData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class WeatherApiServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private WeatherApiService weatherApiService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        weatherApiService = new WeatherApiService(restTemplate);
    }

    @Test
    public void testGetWeatherData_Success() {
        // Create a mock WeatherData object for the response
        WeatherData mockWeatherData = new WeatherData();
        mockWeatherData.setTemperature(25.0);
        mockWeatherData.setDescription("Sunny");

        // Configure the mock RestTemplate to return the mockWeatherData
        when(restTemplate.getForObject(anyString(), eq(WeatherData.class)))
                .thenReturn(mockWeatherData);

        // Call the method to be tested
        WeatherData weatherData = weatherApiService.getWeatherData(37.7749, -122.4194);

        // Verify the result
        assertEquals(25.0, weatherData.getTemperature());
        assertEquals("Sunny", weatherData.getDescription());
    }


}