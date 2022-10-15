package com.main;

public class Formater {
    public static String getDegFromCordinate(double cordinate) {
        double c = Math.abs(cordinate);
        return Integer.toString((int) c);
    }

    public static String getMinFromCordinate(double cordinate) {
        double c = Math.abs(cordinate);
        double desimals = c - ((int) c);
        int min =  (int) Math.round(desimals * 1000);
        return String.format("%03d", min);
    }

    public static String getSecFromCordinate(double cordinate) {
        double c = Math.abs(cordinate);
        double desimals = (c * 1000) - ((int) (c * 1000));
        int sec =  (int) Math.round(desimals * 1000);
        return String.format("%03d", sec);
    }
}
