package com.weather.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.weather.models.IPDetails;
import com.weather.models.WeatherData;
import com.weather.services.GeolocationService;
import com.weather.services.WeatherCache;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final GeolocationService geolocationService;
    private final WeatherCache weatherCache;

    public WeatherController(GeolocationService geolocationService, WeatherCache weatherCache) {
        this.geolocationService = geolocationService;
        this.weatherCache = weatherCache;
    }

    @GetMapping("/{ipAddress}")
    public WeatherData getWeatherByIp(@PathVariable String ipAddress) {
        IPDetails ipDetails = geolocationService.getIPDetails(ipAddress);

        Double latitude = ipDetails.getLatitude();
        Double longitude = ipDetails.getLongitude();

        return weatherCache.getWeatherData(latitude, longitude);
    }
}
