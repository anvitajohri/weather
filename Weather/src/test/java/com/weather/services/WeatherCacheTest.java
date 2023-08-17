package com.weather.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import com.weather.models.WeatherData;

@ExtendWith(MockitoExtension.class)
public class WeatherCacheTest {

    @Mock
    private CacheManager cacheManager;

    @Mock
    private Cache weatherCacheMock;

    @InjectMocks
    private WeatherCache weatherCache;

    @Test
    void testGetWeatherData_CacheMiss() {
        Double latitude = 1.0;
        Double longitude = 2.0;


        // Test the method
        WeatherData result = weatherCache.getWeatherData(latitude, longitude);

        assertNotNull(result);
        assertEquals(25.0, result.getTemperature());
        assertEquals("Sunny", result.getDescription());
    }

}