package BaseClass;

import configurationReaderFile.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    public static AppiumDriver driver;
    public static ConfigReader reader;

    public static void initialize() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        reader = new ConfigReader();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, reader.getAutomationName());
        cap.setCapability(MobileCapabilityType.UDID, reader.udID());
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, reader.getPlatformName());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, reader.getPlatformVersion());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, reader.getDeviceName());
        cap.setCapability("newCommandTimeout", 100000);
        cap.setCapability(MobileCapabilityType.APP, reader.getApkPath());

        URL url = new URL(reader.getAppiumServerURL());
        driver = new AppiumDriver(url, cap);

        AppDriver.setDriver(driver);
    }

    public static void quitDriver(){
        if(null != driver){
            driver.quit();
        }
    }
}