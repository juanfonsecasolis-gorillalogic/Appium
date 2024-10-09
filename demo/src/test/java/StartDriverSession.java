import java.io.File;
import java.net.URL;
import org.openqa.selenium.chrome.ChromeOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartDriverSession {
    
    AppiumDriver appiumDriver;

    @BeforeMethod()
    public void setUp() throws Exception
    {
        ChromeOptions caps = new ChromeOptions();
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:udid", "emulator-5554");
        String appPath = System.getProperty("user.dir") 
            + File.separator 
            + "Downloads"
            + File.separator
            + "ApiDemos-debug.apk";
        Reporter.log( "APP PATH: " + appPath, true );
        caps.setCapability("app", appPath);

        appiumDriver = new AndroidDriver(
            new URL("http://127.0.0.1:4723/"), 
            caps);
    }

    @AfterMethod()
    public void tearDown(){
        appiumDriver.close();
    }

    @Test
    public void SimpleTest() throws InterruptedException
    {
        Thread.sleep(1000);
    }

}
