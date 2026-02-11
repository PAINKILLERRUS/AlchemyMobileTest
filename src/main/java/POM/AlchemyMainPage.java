package POM;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import lombok.Getter;

import static com.codeborne.selenide.appium.SelenideAppium.$;

@Getter
public class AlchemyMainPage {

    private final SelenideElement playButton = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Play\"]"));
    private final SelenideElement suggestAnElementButton = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Suggest an element\"]"));
    private final SelenideElement otherGamesButton = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Other games\"]"));

    private final SelenideElement settingButton = $(AppiumBy.xpath("//android.view.View[@content-desc=\"Settings\"]"));
    private final SelenideElement howToPlayButton = $(AppiumBy.xpath("//android.view.View[@content-desc=\"How to play\"]"));
    private final SelenideElement achievementsButton = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Achievements\"]"));

}
