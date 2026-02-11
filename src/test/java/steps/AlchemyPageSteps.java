package steps;

import POM.AlchemyGamingPage;
import POM.AlchemyMainPage;
import POM.HintScreenPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlchemyPageSteps {

    private final AlchemyMainPage page = new AlchemyMainPage();
    private final AlchemyGamingPage gamingPage = new AlchemyGamingPage();
    private final HintScreenPage hintPage = new HintScreenPage();

    @Step("Возможность добавления подсказок")
    public void possibilityOfAddingHints() {
        page.getPlayButton().shouldBe(visible).click();
        gamingPage.getAddedHintsButton().shouldBe(visible).shouldBe(enabled, Duration.ofSeconds(10)).click();
        gamingPage.getYouHintsHeader().shouldBe(visible, Duration.ofSeconds(15));
        gamingPage.getWatchButton().shouldBe(visible).shouldBe(enabled, Duration.ofSeconds(30)).click();


        String hintsCount = gamingPage.getNumberOfHintsDisplay().getText();
        assertEquals("4", hintsCount);
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
