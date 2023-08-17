package com.weather.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;


public class HistoricalQueryTest {
	

    @Test
    public void testConstructorAndGetters() {
        String ipAddress = "192.168.1.1";
        LocalDateTime queryTimestamp = LocalDateTime.now();

        HistoricalQuery historicalQuery = new HistoricalQuery(ipAddress, queryTimestamp);

        assertEquals(ipAddress, historicalQuery.getIpAddress());
        assertEquals(queryTimestamp, historicalQuery.getQueryTimestamp());
    }

    @Test
    public void testSetters() {
        String newIpAddress = "10.0.0.1";
        LocalDateTime newQueryTimestamp = LocalDateTime.of(2023, 8, 15, 12, 0);

        HistoricalQuery historicalQuery = new HistoricalQuery("192.168.1.1", LocalDateTime.now());

        historicalQuery.setIpAddress(newIpAddress);
        historicalQuery.setQueryTimestamp(newQueryTimestamp);

        assertEquals(newIpAddress, historicalQuery.getIpAddress());
        assertEquals(newQueryTimestamp, historicalQuery.getQueryTimestamp());
    }

    @Test
    public void testIdGeneration() {
        HistoricalQuery historicalQuery1 = new HistoricalQuery("192.168.1.1", LocalDateTime.now());
        HistoricalQuery historicalQuery2 = new HistoricalQuery("10.0.0.1", LocalDateTime.now());

        assertEquals(historicalQuery1.getId(), historicalQuery2.getId());
    }
 
}