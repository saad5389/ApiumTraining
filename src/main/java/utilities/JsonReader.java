package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonReader {

    String jsonFilePath;

    public JsonReader(String filePath) {
        jsonFilePath = filePath;
    }

    public String getValue(String key) {
        //Parsing the data from json file using object
        JSONParser jsonParser = new JSONParser();
        String value = null;
        try {
            //paring the data from json file from its path that will return the json object to map key values
            JSONObject jsonObject = (JSONObject)jsonParser.parse(new FileReader(jsonFilePath));
            //extracting the values using its key
            value = (String)jsonObject.get(key);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
