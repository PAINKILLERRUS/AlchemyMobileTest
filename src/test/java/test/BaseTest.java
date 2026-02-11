package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URL;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeEach
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setPlatformVersion("11")
                .setDeviceName("Pixel 3a")
                .setAppPackage("com.ilyin.alchemy")
                .setAppActivity("com.ilyin.app_google_core.GoogleAppActivity t36")
                .setNoReset(false)
                .setFullReset(false);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        WebDriverRunner.setWebDriver(driver);
        SelenideAppium.launchApp();

        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
