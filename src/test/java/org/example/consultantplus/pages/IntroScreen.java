package org.example.consultantplus.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.consultantplus.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.consultantplus.MyWait.myWait;

public class IntroScreen {
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreen.class));
    @AndroidFindBy(id = "com.consultantplus.app:id/button_next")
    private WebElement buttonNext;


    public Boolean buttonNextEnable(){
        myWait(4).clickable(buttonNext);
        LOG.info("Проверка отображения кнопки Далее");
        return buttonNext.isDisplayed();
    }
    public void buttonNextClick(){
        LOG.info("Нажата  кнопка Далее");
        buttonNext.click();
    }
    @AndroidFindBy(id = "com.consultantplus.app:id/button_skip")
    private WebElement buttonSkipLearning;
    public void skipLearningClick(){
        LOG.info("Нажата кнопка Пропустить");
        buttonSkipLearning.click();
    }

    public IntroScreen(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
