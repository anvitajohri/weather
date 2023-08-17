package com.weather.models;

public class IPDetails {
    private String ipAddress;
    private String city;
    private String country;
    private String region;
    private Double latitude;
    private Double longitude;

    // Constructors
    public IPDetails() {
    }

    public IPDetails(String ipAddress, String city, String country, String region,
    		Double latitude, Double longitude) {
        this.ipAddress = ipAddress;
        this.city = city;
        this.country = country;
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	// Override toString for debugging or display purposes
    @Override
    public String toString() {
        return "IPDetails{" +
                "ipAddress='" + ipAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}