package assignment3;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

public class Util {

    private static Map<String, List<Double>> csvRecords;

    public static Map<String, List<Double>> getInfoFromCSV() {
        if(csvRecords != null) return csvRecords;
        csvRecords = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/assignment3/device_performance_index.csv"))) {
            String[] headerValues = br.readLine().split(",");
            for(String value : headerValues) {
                csvRecords.put(value, new ArrayList<>());
            }

            String line;
            while ((line = br.readLine()) != null) {
                int i = 0;
                String[] values = line.split(",");
                for(String value : values) {
                    csvRecords.get(headerValues[i]).add(Double.valueOf(value));
                    ++i;
                }
            }
            return csvRecords;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateDPIonCSV(String filePath, String[] header, List<String[]> data) {

        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            writer.writeNext(header);

            for(String[] list : data) {
                writer.writeNext(list);
            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
