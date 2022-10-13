package com.nmea;

public class NMEA_Resources {
    public static String CalculateChecksum(String message) {
        int checksum = 0;
  
        for (int i = 0; i < message.length(); i++) {
            checksum = (checksum ^ ((message.charAt(i))));
        }
        
        return Integer.toHexString(checksum);
    }
}
