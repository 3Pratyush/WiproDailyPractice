package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {

    public static Object[][] getCsvData(String filePath)
            throws Exception {

        List<Object[]> records = new ArrayList<>();

        BufferedReader br =
                new BufferedReader(new FileReader(filePath));

        String line;

        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {

            String[] values = line.split(",");

            records.add(values);
        }

        br.close();

        return records.toArray(new Object[0][]);
    }
}