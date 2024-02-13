package org.example.consultantplus;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private static AndroidDriver driver;
    private static final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    @BeforeEach
    public void setUp() {
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Enver\\Downloads\\КонсультантПлюс_9.18.1542_Apkpure.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Samsung A8+");
        desiredCapabilities.setCapability("appium:automationName", "uiAutomator2");
        desiredCapabilities.setCapability("appium:appWaitActivity", "com.consultantplus.app.intro.IntroActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
    }
    public static AndroidDriver getDriver()   {
        URL remouteURl = null;
        try {
            remouteURl = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AndroidDriver(remouteURl, desiredCapabilities);
        return driver;
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
