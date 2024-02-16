package org.example.consultantplus.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.consultantplus.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.consultantplus.MyWait.myWait;

public class SearchDocumentsPage {
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(SearchDocumentsPage.class));
    @AndroidFindBy(id = "com.consultantplus.app:id/search_edit")
    private WebElement searchEdit;

    public String getSearchEditText(){
        myWait(10).visible(searchEdit);
        LOG.info("Получение текста поля " + searchEdit);
        return searchEdit.getText();

    }
    public SearchDocumentsPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
