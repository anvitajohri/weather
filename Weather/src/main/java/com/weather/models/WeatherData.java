package com.weather.models;

public class WeatherData {
    private Double temperature;
    private String description;
    private Double humidity;
    private Double windSpeed;

    // Constructors
    public WeatherData() {
    }

    public WeatherData(Double temperature, String description, Double humidity, Double windSpeed) {
        this.temperature = temperature;
        this.description = description;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    // Getters and Setters
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    // Override toString for debugging or display purposes
    @Override
    public String toString() {
        return "WeatherData{" +
                "temperature=" + temperature +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                '}';
    }
}