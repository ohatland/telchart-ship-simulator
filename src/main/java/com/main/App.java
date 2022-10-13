package com.main;

import com.gui.MainWindow;

public class App {
    public static void main(String[] args) {
        int port = 4020;
        Ship ship = new Ship();
        
        new MainWindow(ship, port);        
        new WebServer(ship, port);
    }
}