package com.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FormaterTest {
    @Test
    public void ShouldExtractDegFromCordinate() {
        double c = 65.35708;

        assertEquals("65", Formater.getDegFromCordinate(c));
    
    }
    @Test
    public void ShouldExtractNegativeDegFromCordinate() {
        double c = -65.35708;

        assertEquals("65", Formater.getDegFromCordinate(c));
    }

    @Test
    public void ShouldExtractMinutesFromCordinate() {
        double c = 65.35708;

        assertEquals("357", Formater.getMinFromCordinate(c));
    }

    @Test
    public void ShouldExtractNegativeMinutesFromCordinate() {
        double c = -65.35708;

        assertEquals("357", Formater.getMinFromCordinate(c));
    }


    @Test
    public void ShouldExtractSecoundsFromCordinate() {
        double c = 65.35708;

        assertEquals("080", Formater.getSecFromCordinate(c));
    }

    @Test
    public void ShouldExtractNegativeSecoundsFromCordinate() {
        double c = -65.35708;

        assertEquals("080", Formater.getSecFromCordinate(c));
    }    
}
