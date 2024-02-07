package org.example.consultantplus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroScreen {
    @AndroidFindBy(id = "com.consultantplus.app:id/button_next")
    private WebElement buttonNext;
    @AndroidFindBy(id = "title")
    private WebElement title;
    public Boolean buttonNextEnable(){
        return buttonNext.isDisplayed();
    }
    public void buttonNextClick(){
        buttonNext.click();
    }
    public boolean titleIsDisplayed(){
        return title.isDisplayed();
    }
    public String getTitleText(){
        return title.getText();
    }
    public IntroScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
