package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.AlchemyPageSteps;

@Epic("UI")
@Feature("Alchemy")
public class AlchemyTests extends BaseTest {

    private final AlchemyPageSteps steps = new AlchemyPageSteps();


    @Test
    @Tag("Positive")
    @Owner("Иван Антипов")
    @Story("Проверка возможности добавление подсказок")
    @DisplayName("Проверка возможности добавление подсказок")
    public void checkingThePossibilityOfAddingHints() {
        steps.possibilityOfAddingHints();
    }

    @Test
    @Tag("Positive")
    @Owner("Иван Антипов")
    @Story("Проверка кликабельности и видимости кнопок главного меню")
    @DisplayName("Проверка кликабельности и видимости кнопок главного меню")
    public void checkingVisibilityAndClickabilityMainMenuButton() {
        steps.visibilityAndClickabilityMainMenuButton();
    }
}
