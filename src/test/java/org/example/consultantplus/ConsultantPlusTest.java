package org.example.consultantplus;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsultantPlusTest {
    private AndroidDriver driver;
    private IntroScreen introScreen;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Enver\\Downloads\\КонсультантПлюс_9.18.1542_Apkpure.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Samsung A8+");
        desiredCapabilities.setCapability("appium:automationName", "uiAutomator2");
        desiredCapabilities.setCapability("appium:appWaitActivity", "com.consultantplus.app.intro.IntroActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);


        URL remouteURl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(remouteURl, desiredCapabilities);
        introScreen = new IntroScreen(driver);
    }

    @Test
    @DisplayName("Тестирование доступности кнопки Далее")
    public void sampleTest() {
        assertTrue(introScreen.buttonNextEnable(), "Нет кнопки Далее");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
