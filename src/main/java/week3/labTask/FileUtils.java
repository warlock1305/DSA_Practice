package week3.labTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static IPAddress[] readFile(String filePath) {
        List<IPAddress> ipAddresses = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while(line!=null){
                String[] record = line.split(";");
                ipAddresses.add(new IPAddress(Long.parseLong(record[0]), Long.parseLong(record[1]), record[2], record[3], record[4], record[5]));

                line = reader.readLine();
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ipAddresses.toArray(new IPAddress[0]);
    }
}
