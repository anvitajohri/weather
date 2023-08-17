package com.weather.exceptions;

@SuppressWarnings("serial")
public class WeatherNotFoundException extends RuntimeException {

    public WeatherNotFoundException(String message) {
        super(message);
    }
}
