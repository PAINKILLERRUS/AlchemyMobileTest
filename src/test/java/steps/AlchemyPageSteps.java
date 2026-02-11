package steps;

import POM.AlchemyGamingPage;
import POM.AlchemyMainPage;
import com.codeborne.selenide.WebDriverRunner;
import helpers.AdHandler;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlchemyPageSteps {

    private final AlchemyMainPage page = new AlchemyMainPage();
    private final AlchemyGamingPage gamingPage = new AlchemyGamingPage();

    @Step("Возможность добавления подсказок")
    public void possibilityOfAddingHints() {
        page.getPlayButton().shouldBe(visible).click();
        gamingPage.getAddedHintsButton().shouldBe(visible).shouldBe(enabled, Duration.ofSeconds(10)).click();
        gamingPage.getYouHintsHeader().shouldBe(visible, Duration.ofSeconds(5));
        gamingPage.getWatchButton().shouldBe(visible).shouldBe(enabled, Duration.ofSeconds(30)).click();
        AdHandler.handleAdAfterWatch();
        waitForGameScreen();
        String hintsCount = gamingPage.getNumberOfHintsDisplay().get(1).shouldBe(visible, Duration.ofSeconds(5)).getText();
        assertEquals("4", hintsCount);
    }

    private void waitForGameScreen() {
        // Явно переключаемся в NATIVE_APP (на всякий случай)
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();
        driver.context("NATIVE_APP");
        // Ждём появления заголовка "Your hints" с увеличенным таймаутом
        gamingPage.getYouHintsHeader().shouldBe(visible, Duration.ofSeconds(20));
    }


    @Step("Кликабельность и видимость кнопок главного меню")
    public void visibilityAndClickabilityMainMenuButton() {
        page.getPlayButton().shouldBe(visible, clickable);
        page.getSuggestAnElementButton().shouldBe(visible, clickable);
        page.getOtherGamesButton().shouldBe(visible, clickable);
        page.getSettingButton().shouldBe(visible, clickable);
        page.getHowToPlayButton().shouldBe(visible, clickable);
        page.getAchievementsButton().shouldBe(visible, clickable);
        page.getPlayButton().shouldBe(visible).click();
        String text = gamingPage.getDailyThanksHeader().shouldBe(visible).getText();
        assertEquals("Daily Tasks", text);
    }
}
