package com.main;

import org.gavaghan.geodesy.*;

public class Ship {

    private GeodeticCalculator calculator = new GeodeticCalculator();
    private GlobalCoordinates position;

    private int bearing = 330;
    private int speedKnots = 0;

    public Ship(GlobalCoordinates p) {
        position = new GlobalCoordinates(
            p.getLatitude(), 
            p.getLongitude()
        );
    }

    public void MoveShipOncePerSecound() {
        double distance = knotsToMeterPerSecound(speedKnots);
        position = calculator.calculateEndingGlobalCoordinates(Ellipsoid.WGS84, position, bearing, distance);
    }

    private double knotsToMeterPerSecound(double knots) {
        // return knots * 0.5144;
        return knots * 0.3086;
    }

    public void TurnOneDegreeSarboard() {
        if (bearing == 0) {
            bearing = 359;
        } else {
            bearing--;
        }
    }

    public void TurnOneDegreePort() {
        if (bearing == 359) {
            bearing = 0;
        } else {
            bearing++;
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

    public void SetPosition(GlobalCoordinates p) {
        position.setLatitude(p.getLatitude());
        position.setLongitude(p.getLongitude());
    }

    public double GetLatitude() {
        return position.getLatitude();
    }
    
    public double GetLongitude() {
        return position.getLongitude();
    }

    public double GetLatitudeAbs() {
        return Math.abs(position.getLatitude());
    }
    
    public double GetLongitudeAbs() {
        return Math.abs(position.getLongitude());
    }

    public char GetLatitudeHemisphere() {
        if (position.getLatitude() > 0) {
            return 'N';
        } else {
            return 'S';
        }
    }

    public char GetLongitudeHemisphere() {
        if (position.getLongitude() > 0) {
            return 'E';
        } else {
            return 'W';
        }
    }

    public String GetBearing() {
        return Integer.toString(bearing);
    }

    public String GetSpeedKnots() {
        return Integer.toString(speedKnots);
    }


}
