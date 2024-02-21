package org.example.consultantplus.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.consultantplus.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.example.consultantplus.MyWait.myWait;

public class MainPage {
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));

    @AndroidFindBy(id = "com.consultantplus.app:id/title")
    private WebElement mainPageTitle;

    public Boolean mainPageTitleIsEnable(){
        myWait(10).visible(mainPageTitle);
        LOG.info("Кнопка на главной странице доступен");
        return mainPageTitle.isDisplayed();
    }
    @AndroidFindBy(id = "com.consultantplus.app:id/search_edit")
    private WebElement searchFiled;
    public Boolean searchFieldIsDisplayed(){
        myWait(10).visible(searchFiled);
        LOG.info("Поиск на главной странице доступен");
        return searchFiled.isDisplayed();
    }
    public void setTextAtSearchField(String searchText){
        LOG.info("В поле поиск ввести знаечение " + searchText);
        searchFiled.sendKeys(searchText);
    }
    @AndroidFindBy(id = "com.consultantplus.app:id/left_button")
    private WebElement leftSearchButton;
    public void leftSearchButtonClick(){
        LOG.info("Нажата кнопка применить поиск");
        leftSearchButton.click();
    }
    //@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='design_menu_item_text' and contains(@text, 'Новости')]")
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckedTextView\").textContains(\"Новости\")" )
    private WebElement news;
    public void newsClick(){
        myWait(10).visible(news);
        LOG.info("Выбраны пункт меню Новости");
        news.click();
    }
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckedTextView\").textContains(\"Кодексы\")" )
    private WebElement codecs;
    public void codecsClick(){
        myWait(10).visible(codecs);
        LOG.info("Выбраны пункт меню Кодексы");
        codecs.click();
    }
    @AndroidFindBy(id = "com.consultantplus.app:id/list_scopes")
    private WebElement filterButton;
    public void filterButtonClick(){
        LOG.info("Раскрывается фильтр");
        filterButton.click();
    }
    public String getfilterButtonText(){
        LOG.info("Получен текс кнопки фильтра");
        return filterButton.getText();
    }

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@class='android.widget.CheckBox']")
    private List<WebElement> checkBox;
    public void clickCheckBox(int count){
        myWait(5).visible(checkBox.get(count));
        LOG.info("Выбран чек бокс под номером" + count + 1 + " и значением " + checkBox.get(count).getText());
        checkBox.get(count).click();
    }
    @AndroidFindBy(id = "com.consultantplus.app:id/apply_btn")
    private WebElement appruvFilterButton;
    @AndroidFindBy(id ="com.consultantplus.app:id/codex_list")
    private WebElement codexList;
    public Boolean codexListIsDisplayed(){
        LOG.info("Проверка отображения кодексов");
        myWait(5).visible(codexList);
        return codexList.isDisplayed();
    }
    public void appruvFilterButtonClick(){
        LOG.info("Применение настроек фильтра");
        appruvFilterButton.click();
    }



    public MainPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
