package com.main;

public class Position {

    public enum LatitudeDirection {
        N,
        S
    }

    public enum LongitudeDirection {
        E,
        W
    }

    public double latitude;
    public LatitudeDirection latitude_direction;
    public double longitude;
    public LongitudeDirection longitude_direction;

    public Position(double latitude, LatitudeDirection latitude_direction, double longitude, LongitudeDirection longitude_direction) {
        this.latitude = latitude;
        this.latitude_direction = latitude_direction;
        this.longitude = longitude;
        this.longitude_direction = longitude_direction;
    }

    public void SetPosition(Position p) {
        this.latitude = p.latitude;
        this.latitude_direction = p.latitude_direction;
        this.longitude = p.longitude;
        this.longitude_direction = p.longitude_direction;
    }

    public void MovePosition(double latitudeMovement, double longitudeMovement){
        if (longitudeMovement > 0) {
            moveEast(longitudeMovement);
        }
        if (longitudeMovement < 0) {
            moveWest(longitudeMovement);
        }
        if (latitudeMovement > 0) {
            moveNort(latitudeMovement);
        }
        if (latitudeMovement < 0) {
            moveSouth(latitudeMovement);
        }
    }

    private void moveEast(double movment) { // movment always positive
        if (longitude_direction == LongitudeDirection.W) {
            if (longitude - movment < 0) {
                longitude = Math.abs(longitude - movment);
                longitude_direction = LongitudeDirection.E;
            } else {
                longitude -= movment;
            }
        }
        else if (longitude_direction == LongitudeDirection.E) {
            longitude += movment;
        }
    }

    private void moveWest(double movment) { // movment always negative
        if (longitude_direction == LongitudeDirection.E) {
            if (longitude + movment < 0) {
                longitude = Math.abs(longitude + movment);
                longitude_direction = LongitudeDirection.W;
            } else {
                longitude += movment;
            }
        }
        else if (longitude_direction == LongitudeDirection.W) {
            longitude -= movment;
        }
    }

    private void moveNort(double movment) { // movment always positive
        if (latitude_direction == LatitudeDirection.S) {
            if (latitude - movment < 0) {
                latitude = Math.abs(latitude - movment);
                latitude_direction = LatitudeDirection.N;
            } else {
                latitude -= movment;
            }
        }
        else if (latitude_direction == LatitudeDirection.N) {
            latitude += movment;
        }
    }

    private void moveSouth(double movment) { // movment always negative
        if (latitude_direction == LatitudeDirection.N) {
            if (latitude + movment < 0) {
                latitude = Math.abs(latitude + movment);
                latitude_direction = LatitudeDirection.S;
            } else {
                latitude += movment;
            }
        }
        else if (latitude_direction == LatitudeDirection.S) {
            latitude -= movment;
        }
    }
}
