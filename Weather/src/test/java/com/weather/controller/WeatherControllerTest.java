package com.weather.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.weather.controllers.WeatherController;
import com.weather.models.IPDetails;
import com.weather.models.WeatherData;
import com.weather.services.GeolocationService;
import com.weather.services.WeatherCache;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherControllerTest {

    @Mock
    private GeolocationService geolocationService;

    @Mock
    private WeatherCache weatherCache;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherByIp() {
        // Mock data
        String ipAddress = "127.0.0.1";
        IPDetails mockIpDetails = new IPDetails();
        mockIpDetails.setLatitude(37.7749);
        mockIpDetails.setLongitude(-122.4194);

        WeatherData mockWeatherData = new WeatherData();
        when(geolocationService.getIPDetails(ipAddress)).thenReturn(mockIpDetails);
        when(weatherCache.getWeatherData(mockIpDetails.getLatitude(), mockIpDetails.getLongitude()))
            .thenReturn(mockWeatherData);

        // Call the controller method
        WeatherData result = weatherController.getWeatherByIp(ipAddress);

        // Verify interactions and assertions
        verify(geolocationService, times(1)).getIPDetails(ipAddress);
        verify(weatherCache, times(1))
            .getWeatherData(mockIpDetails.getLatitude(), mockIpDetails.getLongitude());
        assertEquals(mockWeatherData, result);
    }
}