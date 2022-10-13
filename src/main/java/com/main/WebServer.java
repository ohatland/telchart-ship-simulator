package com.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;

import com.nmea.*;

public class WebServer {

    private ServerSocket serverSocket;
    private Ship ship;

    public WebServer(Ship ship, int port) {
        this.ship = ship;
        start(port);
    }
    
    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            while (true) {
                new WebserverClientHandler(ship, serverSocket.accept()).start();
            }
        } catch (Exception ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void stop() throws IOException{
        serverSocket.close();
    }

    private static class WebserverClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private Ship ship;
        
        public WebserverClientHandler(Ship ship, Socket socket) {
            this.clientSocket = socket;
            this.ship = ship;
        }

        public void run() {
            try {
                System.out.println("Client connected");
                this.clientSocket.setKeepAlive(true);
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                
                while (clientSocket.getKeepAlive()) {
                    ship.MoveShipOncePerSecound();
                    out.println(HDT_Message.GetMessage(ship));
                    out.println(VTG_Message.GetMessage(ship));
                    out.println(GGA_Message.GetMessage(ship));
                    Thread.sleep(1000);
                }

                out.close();
                clientSocket.close();
                System.out.println("Client disconnected");
                
            } catch (Exception e) {
                System.out.println("Clienthandler exception: " + e.getMessage());
                e.printStackTrace();
            }
            
        }
    }
}
