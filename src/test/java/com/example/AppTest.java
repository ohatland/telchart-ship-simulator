package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nmea.NMEA_Resources;

public class AppTest 
{
    @Test
    public void shouldCalculateChecksum() {
        assertEquals("28",NMEA_Resources.CalculateChecksum("GPGLL,5300.97914,N,00259.98174,E,125926,A"));
    }

    @Test
    public void shouldAddNegativeNumbers() {
        int a = 8;
        int b = -3;
        int c = -9;
        assertEquals(5, a+b);
        assertEquals(-1, a+c);
        assertEquals(-12, b+c);
    }
}
