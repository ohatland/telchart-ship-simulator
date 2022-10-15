package com.main;

import org.gavaghan.geodesy.GlobalCoordinates;

import com.gui.MainWindow;

public class App {
    public static void main(String[] args) {
        int port = 4020;

        GlobalCoordinates position = new GlobalCoordinates(
            65.35708,
            12.06250
        );

        Ship ship = new Ship(position);
        
        new MainWindow(ship, port);        
        new WebServer(ship, port);
    }
}