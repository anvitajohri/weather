package com.weather.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.weather.models.HistoricalQuery;
import com.weather.models.HistoricalWeather;
import com.weather.models.IPDetails;
import com.weather.models.WeatherData;
import com.weather.repository.HistoricalQueryRepository;
import com.weather.repository.HistoricalWeatherRepository;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {

    @Mock
    private IPToLocationService ipToLocationService;

    @Mock
    private WeatherApiService weatherApiService;

    @Mock
    private HistoricalQueryRepository historicalQueryRepository;

    @Mock
    private HistoricalWeatherRepository historicalWeatherRepository;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetIPDetails() {
        // Mock data
        String ipAddress = "127.0.0.1";
        IPDetails mockIpDetails = new IPDetails();
        when(ipToLocationService.getIPDetails(ipAddress)).thenReturn(mockIpDetails);

        // Call the service method
        IPDetails result = weatherService.getIPDetails(ipAddress);

        // Verify interactions and assertions
        verify(ipToLocationService, times(1)).getIPDetails(ipAddress);
        verify(historicalQueryRepository, times(1)).save(any(HistoricalQuery.class));
        assertEquals(mockIpDetails, result);
    }

    @Test
    public void testGetWeatherData() {
        // Mock data
        Double latitude = 37.7749;
        Double longitude = -122.4194;
        WeatherData mockWeatherData = new WeatherData();
        when(weatherApiService.getWeatherData(latitude, longitude)).thenReturn(mockWeatherData);

        // Call the service method
        WeatherData result = weatherService.getWeatherData(latitude, longitude);

        // Verify interactions and assertions
        verify(weatherApiService, times(1)).getWeatherData(latitude, longitude);
        verify(historicalWeatherRepository, times(1)).save(any(HistoricalWeather.class));
        assertEquals(mockWeatherData, result);
    }

    @Test
    public void testGetHistoricalQueriesByIpAddress() {
        // Mock data
        String ipAddress = "127.0.0.1";
        List<HistoricalQuery> mockQueries = new ArrayList<>();
        when(historicalQueryRepository.findByIpAddress(ipAddress)).thenReturn(mockQueries);

        // Call the service method
        List<HistoricalQuery> result = weatherService.getHistoricalQueriesByIpAddress(ipAddress);

        // Verify interactions and assertions
        verify(historicalQueryRepository, times(1)).findByIpAddress(ipAddress);
        assertEquals(mockQueries, result);
    }

    @Test
    public void testGetHistoricalWeatherByCoordinates() {
        // Mock data
        Double latitude = 37.7749;
        Double longitude = -122.4194;
        List<HistoricalWeather> mockWeatherList = new ArrayList<>();
        when(historicalWeatherRepository.findByLatitudeAndLongitude(latitude, longitude))
            .thenReturn(mockWeatherList);

        // Call the service method
        List<HistoricalWeather> result = weatherService.getHistoricalWeatherByCoordinates(latitude, longitude);

        // Verify interactions and assertions
        verify(historicalWeatherRepository, times(1)).findByLatitudeAndLongitude(latitude, longitude);
        assertEquals(mockWeatherList, result);
    }

}