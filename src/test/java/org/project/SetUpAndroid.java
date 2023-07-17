package org.project;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

public class SetUpAndroid {
    public AppiumDriver<WebElement> driver;
    static Properties inprop = new Properties();
    private final static String DEVICE_UDID = inprop.getProperty("device.udid");
    private final static String PLATFORM_VERSION = inprop.getProperty("platform.version.android");

    @Before
    public void setUp() throws Exception {
        InputStream input = new FileInputStream("config.properties");
        inprop.load(new InputStreamReader(input, Charset.forName("UTF-8")));
        System.setProperty("webdriver.chrome.driver","webDriver/chromedriver");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", DEVICE_UDID);
        capabilities.setCapability("appium:platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "Appium");
        capabilities.setCapability("appium:browserName", "Chrome");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("Appium SetUp for Android is successful and Appium Driver is launched successfully");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
