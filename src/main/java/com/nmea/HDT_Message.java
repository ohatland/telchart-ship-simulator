package com.nmea;

import com.main.Ship;

public class HDT_Message {
    public static String GetMessage(Ship ship) {
        String messageWithoutChecksum = 
        "HEHDT," + ship.GetBearing() + 
        ",T";
        return "$" + messageWithoutChecksum + "*" + NMEA_Resources.CalculateChecksum(messageWithoutChecksum);
    }
}
