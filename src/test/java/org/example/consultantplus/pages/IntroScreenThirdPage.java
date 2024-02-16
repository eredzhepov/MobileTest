package org.example.consultantplus.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.consultantplus.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.consultantplus.MyWait.myWait;

public class IntroScreenThirdPage {
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreenThirdPage.class));

    @AndroidFindBy(id = "com.consultantplus.app:id/button_next")
    private WebElement buttonNext;
    public Boolean buttonNextEnable(){
        myWait(4).clickable(buttonNext);
        LOG.info("Проверка отображения кнопки Приступить к работе");
        return buttonNext.isDisplayed();
    }
    public IntroScreenThirdPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
