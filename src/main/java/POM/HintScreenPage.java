package POM;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.AppiumSelectors;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import io.appium.java_client.AppiumBy;
import lombok.Getter;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

@Getter
public class HintScreenPage {

    private final SelenideElement skipButton = $(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"));
    private final SelenideAppiumCollection closeButton = $$(AppiumSelectors.byAttribute("class", "android.widget.ImageView"));

}
