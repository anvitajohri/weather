package com.weather.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.models.HistoricalWeather;

@Repository
public interface HistoricalWeatherRepository extends JpaRepository<HistoricalWeather, Long> {

    // Custom query method to find historical weather by latitude and longitude
    List<HistoricalWeather> findByLatitudeAndLongitude(Double latitude, Double longitude);

    // Custom query method to find historical weather within a specific date range
    List<HistoricalWeather> findByTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);

}
