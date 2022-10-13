package com.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.main.Position;
import com.main.Ship;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class SetPositionWindow extends JFrame implements ActionListener {
    Ship ship;

    JFrame frame;

    JButton setPositionButton;

    JTextField latitudeTextField;
    JTextField longitudeTextField;
    JComboBox latitudeDirectionComboBox;
    JComboBox longitudeDirectionComboBox;

    public SetPositionWindow(Ship ship) {
        this.ship = ship;
        frame = new JFrame("Set position");

        setTextAndBoxes();
        setButton();
        
        frame.setSize(400,400); 
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if (obj == setPositionButton) {
            setPosition();
            frame.dispose();
        }
    }

    private void setPosition() {
        ship.SetPosition(new Position(
            Double.parseDouble(latitudeTextField.getText()),
            Position.LatitudeDirection.valueOf(String.valueOf(latitudeDirectionComboBox.getSelectedItem())), 
            Double.parseDouble(longitudeTextField.getText()), 
            Position.LongitudeDirection.valueOf(String.valueOf(longitudeDirectionComboBox.getSelectedItem()))
            )
        );
    }

    private void setTextAndBoxes() {
        latitudeTextField = new JTextField();
        latitudeTextField.setBounds(100,75,100,30);
        latitudeTextField.setText(String.format(Locale.US, "%.3f",ship.position.latitude));

        longitudeTextField = new JTextField();
        longitudeTextField.setBounds(100,150,100,30);
        longitudeTextField.setText(String.format(Locale.US, "%09.3f", ship.position.longitude));

        String[] lat = { "N", "S"};
        String[] lon = { "W", "E"};
        latitudeDirectionComboBox = new JComboBox(lat);
        latitudeDirectionComboBox.setSelectedIndex(0);
        latitudeDirectionComboBox.setBounds(220,75,50,30);
        
        longitudeDirectionComboBox = new JComboBox(lon);
        longitudeDirectionComboBox.setSelectedIndex(1);
        longitudeDirectionComboBox.setBounds(220,150,50,30);

        frame.add(latitudeTextField);
        frame.add(longitudeTextField);
        frame.add(latitudeDirectionComboBox);
        frame.add(longitudeDirectionComboBox);
    }

    private void setButton() {
        setPositionButton = new JButton("Save");
        setPositionButton.setBounds(10, 300, 360, 50);
        setPositionButton.addActionListener(this);
        frame.add(setPositionButton);
    }
}
