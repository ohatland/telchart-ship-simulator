package com.nmea;

import com.main.Ship;

// https://receiverhelp.trimble.com/r750-gnss/NMEA-0183messages_VTG.html

public class VTG_Message {
    public static String GetMessage(Ship ship) {
        String messageWithoutChecksum = 
        "GPVTG," + ship.Heading() + 
        ",T,,M," +
        ship.SpeedKnots() + ",N,,K";
        return "$" + messageWithoutChecksum + "*" + NMEA_Resources.CalculateChecksum(messageWithoutChecksum);
    }
}
