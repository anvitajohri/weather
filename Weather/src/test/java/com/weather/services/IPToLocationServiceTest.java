package com.weather.services;

import com.weather.models.IPDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
@Import(IPToLocationServiceTest.TestConfiguration.class)
public class IPToLocationServiceTest {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private IPToLocationService ipToLocationService;

    @Value("${geolocation.api.url}")
    private String geolocationApiUrl;

    @Test
    public void testGetIPDetails() {
        String ipAddress = "127.0.0.1";
        String apiUrl = geolocationApiUrl + "?ip=" + ipAddress;

        IPDetails expectedDetails = new IPDetails();
        expectedDetails.setIpAddress(ipAddress);

        when(restTemplate.getForObject(apiUrl, IPDetails.class)).thenReturn(expectedDetails);

        IPDetails actualDetails = ipToLocationService.getIPDetails(ipAddress);

        assertEquals(expectedDetails.getIpAddress(), actualDetails.getIpAddress());
    }

    @Configuration
    public static class TestConfiguration {
    	@Bean
        public IPToLocationService ipToLocationService(RestTemplate restTemplate) {
            return new IPToLocationService(restTemplate);
        }
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
}