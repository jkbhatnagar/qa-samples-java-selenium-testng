package org.example.utils;

import org.example.enums.ENVType;
import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class YamlFileService {
    private static YamlFileService instance = new YamlFileService();

    private YamlFileService() {
    }

    public static YamlFileService getYamlLoader() {
        return instance;
    }

    public HashMap<String, Object>  getYamlObjectMap(String dataFile) {
        HashMap<String, Object> objectMap = new HashMap<String, Object>();
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(dataFile);
            objectMap = yaml.load(inputStream);
            inputStream.close();
            Log.info("Data file loaded - dataFile : " + dataFile);
            Log.info(objectMap.toString());
            return objectMap;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return objectMap;
        }
    }
}
