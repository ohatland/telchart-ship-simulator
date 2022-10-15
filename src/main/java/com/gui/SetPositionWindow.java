package com.gui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.gavaghan.geodesy.GlobalCoordinates;

import com.main.Ship;
import com.main.Formater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetPositionWindow extends JFrame implements ActionListener {
    Ship ship;

    JFrame frame;

    JButton setPositionButton;

    JTextField latitudeTextField1;
    JTextField latitudeTextField2;
    JTextField latitudeTextField3;
    JTextField longitudeTextField1;
    JTextField longitudeTextField2;
    JTextField longitudeTextField3;
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
        double latitude = Double.parseDouble(getLatitudeFromTextField());
        if (latitudeDirectionComboBox.getSelectedItem().toString() == "S") {
            latitude *= -1;
        }

        double longitude = Double.parseDouble(getLongitudeFromTextField());
        if (longitudeDirectionComboBox.getSelectedItem().toString() == "W") {
            longitude *= -1;
        }

        ship.SetPosition(new GlobalCoordinates(
            latitude,
            longitude
            )
        );
    }

    private String getLatitudeFromTextField() {
        return latitudeTextField1.getText() + "." + latitudeTextField2.getText() + latitudeTextField3.getText();
    }

    private String getLongitudeFromTextField() {
        return longitudeTextField1.getText() + "." + longitudeTextField2.getText() + longitudeTextField3.getText();
    }

    private void setTextAndBoxes() {
        int latY = 75;
        int lonY = 150;

        latitudeTextField1 = new JTextField();
        latitudeTextField1.setBounds(90,latY,30,30);
        latitudeTextField1.setDocument(new LimitJTextField(2));
        latitudeTextField1.setHorizontalAlignment(JTextField.CENTER);
        latitudeTextField1.setText(Formater.getDegFromCordinate(ship.GetLatitude()));

        latitudeTextField2 = new JTextField();
        latitudeTextField2.setBounds(130,latY,30,30);
        latitudeTextField2.setDocument(new LimitJTextField(3));
        latitudeTextField2.setHorizontalAlignment(JTextField.CENTER);
        latitudeTextField2.setText(Formater.getMinFromCordinate(ship.GetLatitude()));

        latitudeTextField3 = new JTextField();
        latitudeTextField3.setBounds(170,latY,30,30);
        latitudeTextField3.setDocument(new LimitJTextField(3));
        latitudeTextField3.setHorizontalAlignment(JTextField.CENTER);
        latitudeTextField3.setText(Formater.getSecFromCordinate(ship.GetLatitude()));

        longitudeTextField1 = new JTextField();
        longitudeTextField1.setBounds(90,lonY,30,30);
        longitudeTextField1.setDocument(new LimitJTextField(3));
        longitudeTextField1.setHorizontalAlignment(JTextField.CENTER);
        longitudeTextField1.setText(Formater.getDegFromCordinate(ship.GetLongitude()));

        longitudeTextField2 = new JTextField();
        longitudeTextField2.setBounds(130,lonY,30,30);
        longitudeTextField2.setDocument(new LimitJTextField(3));
        longitudeTextField2.setHorizontalAlignment(JTextField.CENTER);
        longitudeTextField2.setText(Formater.getMinFromCordinate(ship.GetLongitude()));
        
        longitudeTextField3 = new JTextField();
        longitudeTextField3.setBounds(170,lonY,30,30);
        longitudeTextField3.setDocument(new LimitJTextField(3));
        longitudeTextField3.setHorizontalAlignment(JTextField.CENTER);
        longitudeTextField3.setText(Formater.getSecFromCordinate(ship.GetLongitude()));

        String[] lat = { "N", "S"};
        String[] lon = { "E", "W"};
        latitudeDirectionComboBox = new JComboBox(lat);
        latitudeDirectionComboBox.setBounds(220,75,50,30);
        if (ship.GetLatitude() > 0) {
            latitudeDirectionComboBox.setSelectedIndex(0);
        } else {
            latitudeDirectionComboBox.setSelectedIndex(1);
        }
        
        longitudeDirectionComboBox = new JComboBox(lon);
        longitudeDirectionComboBox.setBounds(220,150,50,30);
        if (ship.GetLongitude() > 0) {
            longitudeDirectionComboBox.setSelectedIndex(0);
        } else {
            longitudeDirectionComboBox.setSelectedIndex(1);
        }

        frame.add(latitudeTextField1);
        frame.add(latitudeTextField2);
        frame.add(latitudeTextField3);
        frame.add(longitudeTextField1);
        frame.add(longitudeTextField2);
        frame.add(longitudeTextField3);
        frame.add(latitudeDirectionComboBox);
        frame.add(longitudeDirectionComboBox);
    }

    private void setButton() {
        setPositionButton = new JButton("Save");
        setPositionButton.setBounds(10, 300, 360, 50);
        setPositionButton.addActionListener(this);
        frame.add(setPositionButton);
    }

    private class LimitJTextField extends PlainDocument 
    {
        private int max;
        LimitJTextField(int max) {
            super();
            this.max = max;
        }
        public void insertString(int offset, String text, AttributeSet attr) throws BadLocationException {
            if (text == null)
                return;
            if ((getLength() + text.length()) <= max) {
                super.insertString(offset, text, attr);
            }
        }
    }
}
