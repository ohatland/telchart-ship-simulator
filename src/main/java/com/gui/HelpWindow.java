package com.gui;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.Inet4Address;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpWindow extends JFrame{    

    BufferedImage settingsImg;
    BufferedImage testImg;
    JLabel settingsImage;
    JLabel testImage;
    
    public HelpWindow(int port) {
        try {
            settingsImg = ImageIO.read(new File("src\\main\\resources\\TelchartSettings.png"));
            testImg = ImageIO.read(new File("src\\main\\resources\\TelchartTest.png"));
            settingsImage = new JLabel(new ImageIcon(settingsImg));
            testImage = new JLabel(new ImageIcon(testImg));
        } catch (Exception e) {
            settingsImage = new JLabel(e.toString());
            testImage = new JLabel(e.toString());
        }
        
        JFrame frame = new JFrame("Settings helper");
        JLabel helpText = new JLabel("Enter IP and Port into TELchart ECS Setup");
        JLabel helpText2 = new JLabel("A successful test should look like this");
        JLabel serverIP = new JLabel(  "Server IP: " + getServerIP());
        JLabel serverPort = new JLabel("Port: " +Integer.toString(port));        

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
