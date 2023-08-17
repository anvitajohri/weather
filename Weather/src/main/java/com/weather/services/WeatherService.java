package com.weather.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.weather.models.HistoricalQuery;
import com.weather.models.HistoricalWeather;
import com.weather.models.IPDetails;
import com.weather.models.WeatherData;
import com.weather.repository.HistoricalQueryRepository;
import com.weather.repository.HistoricalWeatherRepository;

@Service
public class WeatherService {

    @Autowired
    private IPToLocationService ipToLocationService;

    @Autowired
    private WeatherApiService weatherApiService;

    @Autowired
    private HistoricalQueryRepository historicalQueryRepository;

    @Autowired
    private HistoricalWeatherRepository historicalWeatherRepository;

    @Cacheable("historicalQueries")
    public IPDetails getIPDetails(String ipAddress) {
        IPDetails ipDetails = ipToLocationService.getIPDetails(ipAddress);
        historicalQueryRepository.save(new HistoricalQuery(ipAddress, LocalDateTime.now()));
        return ipDetails;
    }

    @Cacheable("historicalWeather")
    public WeatherData getWeatherData(Double latitude, Double longitude) {
        WeatherData weatherData = weatherApiService.getWeatherData(latitude, longitude);
        historicalWeatherRepository.save(new HistoricalWeather(latitude, longitude, LocalDateTime.now(), weatherData.getDescription()));
        return weatherData;
    }

    public List<HistoricalQuery> getHistoricalQueriesByIpAddress(String ipAddress) {
        return historicalQueryRepository.findByIpAddress(ipAddress);
    }

    public List<HistoricalWeather> getHistoricalWeatherByCoordinates(Double latitude, Double longitude) {
        return historicalWeatherRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

}