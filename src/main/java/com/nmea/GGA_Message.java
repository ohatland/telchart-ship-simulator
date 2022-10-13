package com.nmea;

// https://orolia.com/manuals/VSP/Content/NC_and_SS/Com/Topics/APPENDIX/NMEA_GGAmess.htm

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.main.Ship;

public class GGA_Message {
    
    private static DateTimeFormatter f = DateTimeFormatter.ofPattern("HHmmss.SS");
    
    public static String GetMessage(Ship ship){
        String messageWithoutChecksum =  
            "GPGGA," + 
            LocalTime.now().format(f) + "," + 
            ship.position.latitude + "," +
            ship.position.latitude_direction + "," +
            String.format(Locale.US, "%016.10f", ship.position.longitude) + "," +
            ship.position.longitude_direction + "," +
            "1,12,,0,M,,M,,";
        return "$" + messageWithoutChecksum + "*" + NMEA_Resources.CalculateChecksum(messageWithoutChecksum);
    }

    


}
