package week3.labTask;

import java.util.Locale;

public class IPSearch {

    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {
        String[] s = ipAddress.split("\\.");
        long number = 16777216 * Long.parseLong(s[0]) + 65536 * Long.parseLong(s[1]) + 256 * Long.parseLong(s[2]) + Long.parseLong(s[3]);

        //I added this checker because otherwise it was going to check the whole array when there was an invalid ip ,which took quite a long time
        if(number < ipAddresses[0].getStartIp() || number > ipAddresses[ipAddresses.length-1].getEndIp()){
            return null;
        }

        int l = 0;
        int h = ipAddresses.length;

        IPAddress answer;

        while (l <= h) {
            int t = l + ((h - l) / 2);
            if (number >= ipAddresses[t].getStartIp() && number <= ipAddresses[t].getEndIp()) {
                return ipAddresses[t];
            } else if (number < ipAddresses[t].getStartIp()) {
                h = t;
            } else if (number > ipAddresses[t].getEndIp()) {
                l = t;
            }
        }
        return null;
    }
}