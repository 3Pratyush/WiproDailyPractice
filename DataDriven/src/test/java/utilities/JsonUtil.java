package utilities;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static Object[][] getJsonData(String filePath) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<Map<String, String>> data =
                mapper.readValue(
                        new File(filePath),
                        new TypeReference<List<Map<String, String>>>() {
                        });

        Object[][] result = new Object[data.size()][2];

        for (int i = 0; i < data.size(); i++) {

            result[i][0] = data.get(i).get("username");
            result[i][1] = data.get(i).get("password");
        }

        return result;
    }
}