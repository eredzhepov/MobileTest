package org.example.consultantplus.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.consultantplus.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.consultantplus.MyWait.myWait;

public class IntroScreenSecondPage {
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(IntroScreenSecondPage.class));
    @AndroidFindBy(id = "title") // Уточнить локатор
    private WebElement title;
    public boolean titleIsDisplayed(){
        myWait(5).visible(title);
        LOG.info("Проверка отображения Тайтла на 2-й странице подсказки");
        return title.isDisplayed();
    }
    public String getTitleText() {
        myWait(5).visible(title);
        LOG.info("Вернуть текст Тайтла на 2-й странице подсказки");
        return title.getText();
    }
    public IntroScreenSecondPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
