package utils;

import model.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVParser {

    private static final String FILE_PATH = "src/main/resources/data.csv";

    public void parseCSV(){
        System.out.println("Parsing CSV file and extracting data...");
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] index = line.split(",");
                String user_id = index[0];
                LocalDateTime date_joined = LocalDateTime.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(index[1]));
                long spend = Long.parseLong(index[2]);
                int device_height = Integer.parseInt(index[4]);
                int device_width = Integer.parseInt(index[5]);
                new User(user_id,date_joined,spend,device_height,device_width);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        } finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                    System.exit(1);
                }
            }
        }
        System.out.println("Parsing and data extraction complete.");
    }

}
