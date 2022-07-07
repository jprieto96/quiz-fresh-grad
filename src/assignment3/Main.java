package assignment3;

import java.util.*;

public class Main {

    /*
        For this exercise I did everything I could, I did not have much time to resolve it
        completely and correctly.

     */

    public static void main(String[] args) {
        // Get info from CSV
        Map<String, List<Double>> csvRecords = Util.getInfoFromCSV();

        // Pass to our library data to work with
        DPIUtil dpiUtil = new DPIUtil(csvRecords);

        // Get MIN for each field
        Map<String, Double> minimumMap = dpiUtil.getMin();

        // Get MAX for each field
        Map<String, Double> maximumMap = dpiUtil.getMax();

        // Normalize
        Map<String, List<Double>> normalizedMap = dpiUtil.normalize(minimumMap, maximumMap);

        // Flip values except System_Free_Space
        Map<String, List<Double>> flippedValuesMap = dpiUtil.flipValues(normalizedMap);

        // Calculate DPI for each value
        List<Double> dpiValues = dpiUtil.calculateDPI(flippedValuesMap);

        // Print each DPI for each Client ID and Office ID
        List<Integer> clients = new ArrayList<>();
        for(Double client : csvRecords.get("Client_ID")) {
            clients.add((int) Math.round(client));
        }
        List<Integer> offices = new ArrayList<>();
        for(Double office : csvRecords.get("Office_ID")) {
            offices.add((int) Math.round(office));
        }

        System.out.println("Client_ID  Office_ID  DPI");
        for(int i = 0; i < dpiValues.size(); i++) {
            System.out.println(clients.get(i) + "  " + offices.get(i) + "  " + dpiValues.get(i));
        }

        // Generate CSV with the DPI for each ClientID - OfficeID
        String[] header = { "Client_ID", "Office_ID", "DPI" };
        List<String[]> data = new ArrayList<>();

        String[] rowData = new String[header.length];
        for(int i = 0; i < clients.size(); i++) {
            rowData[0] = String.valueOf(clients.get(i));
            rowData[1] = String.valueOf(offices.get(i));
            rowData[2] = String.valueOf(dpiValues.get(i));
            data.add(rowData);
        }

        Util.generateDPIonCSV("src/assignment3/DPIgenerated.csv", header, data);

    }

}
