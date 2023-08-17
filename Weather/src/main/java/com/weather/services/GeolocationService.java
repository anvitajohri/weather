package com.weather.services;

import org.springframework.stereotype.Service;

import com.weather.models.IPDetails;

import org.springframework.web.client.RestTemplate;

@Service
public class GeolocationService {

    private final RestTemplate restTemplate;

    public GeolocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public IPDetails getIPDetails(String ipAddress) {
        String apiUrl = "https://api.example.com/geolocation?ip=" + ipAddress;

        IPDetails ipDetails = restTemplate.getForObject(apiUrl, IPDetails.class);

        return ipDetails;
    }
}