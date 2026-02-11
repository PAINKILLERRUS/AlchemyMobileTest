package POM;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumSelectors;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import lombok.Getter;

import static com.codeborne.selenide.appium.SelenideAppium.*;

@Getter
public class AlchemyGamingPage {

    private final SelenideAppiumElement addedHintsButton = $x("//android.view.View[@clickable='true' and .//android.widget.TextView[number(@text) > 0]]");
    private final SelenideElement dailyThanksHeader = $(AppiumBy.xpath("//android.widget.TextView[@text=\"Daily Tasks\"]"));

    //You hints
    private final SelenideElement watchButton = $x("//android.widget.TextView[@text='For watching ads']/..//android.view.View[@clickable='true']");
    private final SelenideAppiumCollection numberOfHintsDisplay = $$(AppiumSelectors.byAttribute("class", "android.widget.TextView"));
    private final SelenideElement youHintsHeader = $x("//android.widget.TextView[@text='Your hints']");

}
