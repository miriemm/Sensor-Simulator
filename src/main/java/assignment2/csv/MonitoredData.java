package assignment2.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonitoredData{

    public static List<List<String>> readData() {

        List<List<String>> records = new ArrayList<List<String>>();
        try (
                CSVReader csvReader = new CSVReader(new FileReader("sensor.csv"));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return records;
    }


}
