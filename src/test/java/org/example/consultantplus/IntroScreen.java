package org.example.consultantplus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroScreen {
    @AndroidBy(id = "button_next")
    private WebElement buttonNext;

    public Boolean buttonNextEnable(){
        return buttonNext.isDisplayed();
    }
    public IntroScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
