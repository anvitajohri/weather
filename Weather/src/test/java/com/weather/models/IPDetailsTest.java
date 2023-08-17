package com.weather.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPDetailsTest {

    @Test
    public void testGettersAndSetters() {
        String ipAddress = "192.168.1.1";
        String city = "Sample City";
        String country = "Sample Country";
        String region = "Sample Region";
        Double latitude = 37.7749;
        Double longitude = -122.4194;

        IPDetails ipDetails = new IPDetails();
        ipDetails.setIpAddress(ipAddress);
        ipDetails.setCity(city);
        ipDetails.setCountry(country);
        ipDetails.setRegion(region);
        ipDetails.setLatitude(latitude);
        ipDetails.setLongitude(longitude);

        assertEquals(ipAddress, ipDetails.getIpAddress());
        assertEquals(city, ipDetails.getCity());
        assertEquals(country, ipDetails.getCountry());
        assertEquals(region, ipDetails.getRegion());
        assertEquals(latitude, ipDetails.getLatitude());
        assertEquals(longitude, ipDetails.getLongitude());
    }

    @Test
    public void testToString() {
        String ipAddress = "192.168.1.1";
        String city = "Sample City";
        String country = "Sample Country";
        String region = "Sample Region";
        Double latitude = 37.7749;
        Double longitude = -122.4194;

        IPDetails ipDetails = new IPDetails(ipAddress, city, country, region, latitude, longitude);
        String expectedToString = "IPDetails{" +
                "ipAddress='" + ipAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
        
        assertEquals(expectedToString, ipDetails.toString());
    }
}