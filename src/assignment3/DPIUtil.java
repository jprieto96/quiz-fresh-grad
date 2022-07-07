package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DPIUtil {

    private Map<String, List<Double>> data;

    public DPIUtil(Map<String, List<Double>> data) {
        this.data = data;
    }

    public Map<String, Double> getMin() {
        Map<String, Double> minimum = new HashMap<>();
        for(String key : data.keySet()) {
            if(isNotCientIdAndOfficeID(key)) {
                Double min = data.get(key).get(0);
                for(Double value : data.get(key)) {
                    min = Math.min(value, min);
                    minimum.put(key, min);
                }
            }
        }
        return minimum;
    }

    public Map<String, Double> getMax() {
        Map<String, Double> maximum = new HashMap<>();
        for(String key : data.keySet()) {
            if(isNotCientIdAndOfficeID(key)) {
                Double max = data.get(key).get(0);
                for(Double value : data.get(key)) {
                    max = Math.max(value, max);
                    maximum.put(key, max);
                }
            }
        }
        return maximum;
    }

    private boolean isNotCientIdAndOfficeID(String key) {
        return !key.equals("Client_ID") && !key.equals("Office_ID");
    }

    public Map<String, List<Double>> normalize(Map<String, Double> minimumMap, Map<String, Double> maximumMap) {
        Map<String, List<Double>> dataNormalized = new HashMap<>();
        for(String key : minimumMap.keySet()) {
            List<Double> normalizedList = new ArrayList<>();
            for (Double value : data.get(key)) {
                Double normalizedValue = Math.min(1, Math.max(0, (value - minimumMap.get(key)) / (maximumMap.get(key) - minimumMap.get(key))));
                normalizedList.add(normalizedValue);
            }
            dataNormalized.put(key, normalizedList);
        }
        return dataNormalized;
    }

    public Map<String, List<Double>> flipValues(Map<String, List<Double>> normalizedMap) {
        Map<String, List<Double>> flippedValues = new HashMap<>();
        for(String key : normalizedMap.keySet()) {
            if(key.equals("System_Free_Space")) {
                flippedValues.put(key, normalizedMap.get(key));
            }
            else {
                List<Double> newValues = new ArrayList<>();
                for (Double value : normalizedMap.get(key)) {
                    Double newValue = 1 - value;
                    newValues.add(newValue);
                }
                flippedValues.put(key, newValues);
            }
        }
        return flippedValues;
    }

    public List<Double> calculateDPI(Map<String, List<Double>> flippedValues) {
        List<Double> dpi = new ArrayList<>();
        List<Double> BSOD_count_array = flippedValues.get("BSOD_count");
        List<Double> Hard_reset_count_array = flippedValues.get("Hard_reset_count");
        List<Double> Boot_Speed_array = flippedValues.get("Boot_Speed");
        List<Double> Logon_Duration_array = flippedValues.get("Logon_Duration");
        List<Double> CPU_Usage_array = flippedValues.get("CPU_Usage");
        List<Double> Memory_Usage_array = flippedValues.get("Memory_Usage");
        List<Double> System_Free_Space_array = flippedValues.get("System_Free_Space");
        for(int i = 0; i < BSOD_count_array.size(); i++) {
            Double acumValue = BSOD_count_array.get(i);
            acumValue += Hard_reset_count_array.get(i);
            acumValue += Boot_Speed_array.get(i);
            acumValue += Logon_Duration_array.get(i);
            acumValue += CPU_Usage_array.get(i);
            acumValue += Memory_Usage_array.get(i);
            acumValue += System_Free_Space_array.get(i);
            Double finalDPIvalue = (10 / 7) * acumValue;
            dpi.add(finalDPIvalue);
        }
        return dpi;
    }

}
