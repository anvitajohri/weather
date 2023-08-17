package com.weather.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.models.HistoricalQuery;

@Repository
public interface HistoricalQueryRepository extends JpaRepository<HistoricalQuery, Long> {

	// Custom query method to find historical queries by IP address
    List<HistoricalQuery> findByIpAddress(String ipAddress);

    // Custom query method to find historical queries within a specific date range
    List<HistoricalQuery> findByQueryTimestampBetween(LocalDateTime startDate, LocalDateTime endDate);

}