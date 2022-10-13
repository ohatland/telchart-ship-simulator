package com.main;

import com.main.Position.*;

public class Ship {
    public Position position = new Position(
        6528.490,
        LatitudeDirection.N,
        1212.457,
        LongitudeDirection.E
    );

    private int heading = 33;
    private int speedKnots = 0;

    public void MoveShipOncePerSecound() {
        double speedNauticalMilesPerSecound = nauticalMilesPerSecound(speedKnots);
        double latitudeMovement = latitudeMovement(heading, speedNauticalMilesPerSecound);
        double longitudeMovement = longitudeMovement(heading, speedNauticalMilesPerSecound);
        double longitudeMovementAdjusted = adjustLongitudeSpeed(longitudeMovement);

        position.MovePosition(latitudeMovement, longitudeMovementAdjusted);
    }

    public void TurnOneDegreeSarboard() {
        if (heading == 0) {
            heading = 359;
        } else {
            heading--;
        }
    }

    public void TurnOneDegreePort() {
        if (heading == 359) {
            heading = 0;
        } else {
            heading++;
        }
    }

    public void IncreaseSpeedOneKnot() {
        speedKnots++;
    }

    public void DecreaseSpeedOneKnot() {
        speedKnots--;
    }

    public void SetSpeed(int speed) {
        speedKnots = speed;
    }

    public void SetPosition(Position p) {
        position.SetPosition(p);
    }

    private double latitudeMovement(int heading, double speed) {
        return Math.sin(Math.toRadians(heading-90)*-1) * speed;
    }

    private double longitudeMovement(int heading, double speed) {
        return Math.cos(Math.toRadians(heading-90)*-1) * speed;
    }

    private double nauticalMilesPerSecound(int speedKnots) {
        return speedKnots * 0.00027777777777778;
    } 

    
    private double adjustLongitudeSpeed(double longitudeMovement) {
        int earthsRadius = 6950000;
        // int earthsRadius = 6378100;
        double modifier = 1852 / ((2 * Math.PI * earthsRadius * Math.cos(Math.toRadians(position.latitude))) / 36000);
        return longitudeMovement * modifier;
    }

    public String Heading() {
        return Integer.toString(heading);
    }

    public String SpeedKnots() {
        return Integer.toString(speedKnots);
    }


}
