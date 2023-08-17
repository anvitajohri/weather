package com.weather.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class HistoricalQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;
    private LocalDateTime queryTimestamp;

    // Constructors
    
    public HistoricalQuery() {
    }

    public HistoricalQuery(String ipAddress, LocalDateTime queryTimestamp) {
        this.ipAddress = ipAddress;
        this.queryTimestamp = queryTimestamp;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getQueryTimestamp() {
        return queryTimestamp;
    }

    public void setQueryTimestamp(LocalDateTime queryTimestamp) {
        this.queryTimestamp = queryTimestamp;
    }
}