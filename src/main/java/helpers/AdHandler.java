package helpers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class AdHandler {

    private static final By CLOSE_BUTTON = AppiumBy.androidUIAutomator("new UiSelector().description(\"Close\")");

    private static final By CLOSE_XPATH = By.xpath("//android.widget.ImageView[@content-desc='Close' or @content-desc='Закрыть']");

    private static final By AD_LOADING_INDICATOR = By.xpath("//*[contains(@text,'Ad loading') or contains(@text,'Реклама загружается')]");

    /**
     * Обработать рекламу, которая появляется после нажатия на watchButton.
     * Стратегия:
     * 1. Ждём появления рекламы (или индикатора загрузки) до 5 секунд.
     * 2. Если есть крестик — закрываем рекламу.
     * 3. Если крестика нет — ждём до 30 секунд, пока реклама не исчезнет сама.
     * 4. Если реклама в WebView — переключаем контекст и закрываем.
     */
    public static void handleAdAfterWatch() {
        sleep(2000);

        // Если был WebView — принудительно переключаемся обратно в NATIVE_APP
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        if (!driver.getContext().equals("NATIVE_APP")) {
            driver.context("NATIVE_APP");
        }

        //Закрываем рекламу (крестик или системный back)
        tryToCloseWithButton();

        //Принудительно активируем своё приложение (если фокус ушёл)
        driver.activateApp("com.ilyin.alchemy");

        //Ждём, пока исчезнут возможные следы рекламы
        waitForAdToDisappear();

        //Дополнительная пауза для отрисовки интерфейса
        sleep(2000);
    }

    private static boolean tryToCloseWithButton() {
        SelenideElement closeBtn = $(CLOSE_BUTTON);
        if (!closeBtn.exists() || !closeBtn.isDisplayed()) {
            closeBtn = $(CLOSE_XPATH);
        }
        if (closeBtn.exists() && closeBtn.isDisplayed()) {
            closeBtn.click();
            closeBtn.should(disappear, Duration.ofSeconds(10));
            return true;
        }
        return false;
    }

    private static void waitForAdToDisappear() {
        // Ждём, пока исчезнет индикатор загрузки рекламы или любой recognisable ad-элемент
        try {
            WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(AD_LOADING_INDICATOR));
        } catch (Exception e) {
            // Если индикатора нет — просто пауза, так как неизвестно, как долго длится реклама
            sleep(15000); // разумное ожидание для короткого видео
        }
    }
}
