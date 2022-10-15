package com.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import com.main.Ship;

public class MainWindow extends JFrame implements ActionListener, KeyListener{
    Ship ship;
    int port;

    JFrame frame;
    
    JButton turnPortButton; 
    JButton turnStarboardButton;
    JButton increaseSpeedButton;
    JButton decreaseSpeedButton; 
    JButton setPositionButton; 
    JButton helpButton;

    JLabel headingText;
    JLabel headingInfoText;
    JLabel speedText;
    JLabel speedInfoText;

    public MainWindow(Ship ship, int port) {
        this.ship = ship;
        this.port = port;

        frame = new JFrame("Telchart Ship Simulator");

        setButtons();

        setText();

        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400); //width, height  
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.setFocusTraversalKeysEnabled(false);
    }

    private void setPositionWindow() {
        new SetPositionWindow(ship);
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            ship.TurnOneDegreePort();
        else if(e.getKeyCode()== KeyEvent.VK_LEFT)
            ship.TurnOneDegreeSarboard();
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
            ship.DecreaseSpeedOneKnot();
        else if(e.getKeyCode()== KeyEvent.VK_UP)
            ship.IncreaseSpeedOneKnot();

        updateText();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if (obj == turnPortButton)
            ship.TurnOneDegreePort();
        else if (obj == turnStarboardButton)
            ship.TurnOneDegreeSarboard();
        else if (obj == increaseSpeedButton)
            ship.IncreaseSpeedOneKnot();
        else if (obj == decreaseSpeedButton)
            ship.DecreaseSpeedOneKnot();
        else if (obj == setPositionButton)
            setPositionWindow();
        else if (obj == helpButton)
            new HelpWindow(port);

        updateText();
        frame.requestFocus();
    }
    
    private void updateText() {
        headingText.setText(ship.GetBearing());
        speedText.setText(ship.GetSpeedKnots());
    }
    
    private void setText() {
        headingInfoText = new JLabel("Heading", SwingConstants.CENTER);
        headingText = new JLabel("0", SwingConstants.CENTER);
        speedInfoText = new JLabel("Speed", SwingConstants.CENTER);
        speedText = new JLabel("0", SwingConstants.CENTER);
        
        headingInfoText.setBounds(50,50,125,30);
        headingText.setBounds(50,100,125,30);
        speedInfoText.setBounds(225,50,100,30);
        speedText.setBounds(225,100,100,30);

        headingText.setFont(new Font("Sans", Font.PLAIN, 36));
        speedText.setFont(new Font("Sans", Font.PLAIN, 36));
        
        frame.add(headingInfoText);
        frame.add(headingText);
        frame.add(speedInfoText);
        frame.add(speedText);

        updateText();
    }
    
    private void setButtons() {
        turnPortButton = new JButton(">>");
        turnStarboardButton = new JButton("<<");
        increaseSpeedButton = new JButton("+");
        decreaseSpeedButton = new JButton("-");
        setPositionButton = new JButton("Set position");
        helpButton = new JButton("Settings help");

        turnStarboardButton.setBounds(50, 250, 50, 50); //x axis, y axis, width, height 
        turnPortButton.setBounds(125, 250, 50, 50);
        increaseSpeedButton.setBounds(250, 175, 50, 50);
        decreaseSpeedButton.setBounds(250, 250, 50, 50); 
        setPositionButton.setBounds(0,0,400,30);
        helpButton.setBounds(0,342,400,20);

        turnPortButton.addActionListener(this);
        turnStarboardButton.addActionListener(this);
        increaseSpeedButton.addActionListener(this);
        decreaseSpeedButton.addActionListener(this);
        setPositionButton.addActionListener(this);
        helpButton.addActionListener(this);

        frame.add(turnPortButton);
        frame.add(turnStarboardButton);
        frame.add(increaseSpeedButton);
        frame.add(decreaseSpeedButton);
        frame.add(setPositionButton);
        frame.add(helpButton);
    }

    public void keyTyped(KeyEvent e) {
        
    }

    public void keyReleased(KeyEvent e) {
        
    }
}
