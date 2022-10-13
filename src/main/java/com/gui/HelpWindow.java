package com.gui;

import java.awt.Font;
import java.net.Inet4Address;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpWindow extends JFrame{    
    public HelpWindow(int port) {
        URL url1 = null;
        URL url2 = null;
        try {
            url1 = new URL("https://raw.githubusercontent.com/ohatland/telchart-ship-simulator/main/src/main/java/com/gui/TelchartSettings.png");
            url2 = new URL("https://raw.githubusercontent.com/ohatland/telchart-ship-simulator/main/src/main/java/com/gui/TelchartTest.png");
        } catch (Exception e) {
            // TODO: handle exception
        }
        JFrame frame = new JFrame("Settings helper");
        JLabel helpText = new JLabel("Enter IP and Port into TELchart ECS Setup");
        JLabel helpText2 = new JLabel("A successful test should look like this");
        JLabel serverIP = new JLabel(  "Server IP: " + getServerIP());
        JLabel serverPort = new JLabel("Port: " +Integer.toString(port));
        JLabel settingsImage = new JLabel(new ImageIcon(url1));
        JLabel testImage = new JLabel(new ImageIcon(url2));

        helpText.setBounds(50,20,800,50);
        helpText2.setBounds(50,350,300,50);
        serverIP.setBounds(50,100,250,30);
        serverPort.setBounds(50,140,150,30);
        settingsImage.setBounds(250,50,500,300);
        testImage.setBounds(0,380,500,200);

        helpText.setFont(new Font("Sans", Font.PLAIN, 36));
        serverIP.setFont(new Font("Sans", Font.PLAIN, 22));
        serverPort.setFont(new Font("Sans", Font.PLAIN, 22));

        frame.add(helpText);
        frame.add(helpText2);
        frame.add(serverIP);
        frame.add(serverPort);
        frame.add(settingsImage);
        frame.add(testImage);

        frame.setSize(800,650); //width, height  
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private String getServerIP() {
        String s = "";
        try {
            s = Inet4Address.getLocalHost().getHostAddress();
        } catch (Exception e) {
            System.out.println("Krise, server har ingen IP");
        }
        return s;
    }
}
