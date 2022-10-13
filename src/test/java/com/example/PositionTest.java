package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.main.Position;
import com.main.Position.LatitudeDirection;
import com.main.Position.LongitudeDirection;

public class PositionTest {
    @Test
    public void DirectionShoudChangeFromNorthToSouth() {
        Position p = new Position(1, LatitudeDirection.N, 0, LongitudeDirection.E);
        p.MovePosition(-3, 0);

        assertEquals(2, p.latitude, 0);
        assertEquals(LatitudeDirection.S, p.latitude_direction);
        
        p.MovePosition(-3, 0);

        assertEquals(5, p.latitude, 0);
        assertEquals(LatitudeDirection.S, p.latitude_direction);
    }

    @Test
    public void DirectionShoudChangeFromSouthToNorth() {
        Position p = new Position(1, LatitudeDirection.S, 0, LongitudeDirection.E);
        p.MovePosition(3, 0);

        assertEquals(2, p.latitude, 0);
        assertEquals(LatitudeDirection.N, p.latitude_direction);
        
        p.MovePosition(3, 0);

        assertEquals(5, p.latitude, 0);
        assertEquals(LatitudeDirection.N, p.latitude_direction);
    }

    @Test
    public void DirectionShouldChangeFromEastToWest() {
        Position p = new Position(0, LatitudeDirection.S, 1, LongitudeDirection.E);
        p.MovePosition(0, -4);
        
        assertEquals(3, p.longitude, 0);
        assertEquals(LongitudeDirection.W, p.longitude_direction);
        
        p.MovePosition(0, -4);
        
        assertEquals(7, p.longitude, 0);
        assertEquals(LongitudeDirection.W, p.longitude_direction);
    }

    @Test
    public void DirectionShouldChangeFromWestToEast() {
        Position p = new Position(0, LatitudeDirection.S, 1, LongitudeDirection.W);
        p.MovePosition(0, 4);

        assertEquals(3, p.longitude, 0);
        assertEquals(LongitudeDirection.E, p.longitude_direction);

        p.MovePosition(0, 4);
        
        assertEquals(7, p.longitude, 0);
        assertEquals(LongitudeDirection.E, p.longitude_direction);
    }
}
