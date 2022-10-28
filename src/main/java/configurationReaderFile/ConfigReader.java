package configurationReaderFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties properties;

    public ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "Configuration/Config.properties";

        try{
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String getAutomationName() {
        String autoName = properties.getProperty("automationName");
        if(autoName != null)
            return autoName;
        else throw new RuntimeException("automation name not found");
    }

    public String getPlatformName() {
        String platformName = properties.getProperty("platformName");
        if(platformName != null)
            return platformName;
        else throw new RuntimeException("platform name not found");
    }

    public String udID() {
        String id = properties.getProperty("udId");
        if(id != null)
            return id;
        else throw new RuntimeException("udID not found");
    }

    public String getPlatformVersion() {
        String platformVersion = properties.getProperty("platformVersion");
        if(platformVersion != null)
            return platformVersion;
        else throw new RuntimeException("platform name not found");
    }

    public String getDeviceName() {
        String deviceName = properties.getProperty("deviceName");
        if(deviceName != null)
            return deviceName;
        else throw new RuntimeException("device name not found");
    }

    public String getApkPath() {
        String path = properties.getProperty("apkPath");
        if(path != null)
            return path;
        else throw new RuntimeException("apkPath not found");
    }

    public String getAppiumServerURL() {
        String serverURL = properties.getProperty("appiumServerURL");
        if(serverURL != null)
            return serverURL;
        else throw new RuntimeException("Server URL not found");
    }

    public String getJSONFilePath() {
        String path = properties.getProperty("filePath");
        if(path != null)
            return path;
        else throw new RuntimeException("file Path");
    }

}
