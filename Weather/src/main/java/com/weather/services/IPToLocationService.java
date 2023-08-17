package com.weather.services;

import com.weather.models.IPDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IPToLocationService {

    private final RestTemplate restTemplate;

    @Value("${geolocation.api.url}")
    private String geolocationApiUrl;

    public IPToLocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public IPDetails getIPDetails(String ipAddress) {
        String apiUrl = geolocationApiUrl + "?ip=" + ipAddress;

        IPDetails ipDetails = restTemplate.getForObject(apiUrl, IPDetails.class);

        return ipDetails;
    }
}