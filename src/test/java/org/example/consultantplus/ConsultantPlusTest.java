package org.example.consultantplus;

import org.example.consultantplus.pages.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsultantPlusTest extends BaseTest{

    private IntroScreen introScreen;
    private IntroScreenSecondPage introScreenSecondPage;
    private IntroScreenThirdPage introScreenThirdPage;
    private MainPage mainPage;
    private SearchDocumentsPage searchDocumentsPage;
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        introScreen = new IntroScreen(getDriver());
        introScreenSecondPage = new IntroScreenSecondPage(getDriver());
        introScreenThirdPage = new IntroScreenThirdPage(getDriver());
        mainPage = new MainPage(getDriver());
        searchDocumentsPage = new SearchDocumentsPage(getDriver());

    }
    @Test
    @DisplayName("Тестирование доступности кнопки Далее")
    @Tag("1")
    public void sampleTest() {
        assertTrue(introScreen.buttonNextEnable(), "Нет кнопки Далее");
    }
    @Test
    @DisplayName("Отображение заголовка на 2-й странице обучения")
    @Tag("2")
    public void titleIsDisplayed() {
        introScreen.buttonNextClick();
        assertTrue(introScreenSecondPage.titleIsDisplayed(), "Нет заголовка");
    }
    @Test
    @DisplayName("Проверка соответсвия title")
    @Tag("3")
    public void checkTitle() {
        String title = "Работа без интернета";
        introScreen.buttonNextClick();
        assertEquals(introScreenSecondPage.getTitleText(), title, "Заголовки не соответстуют");
    }
    @Test
    @DisplayName("Проверить активность кнопки Приступить к работе")
    @Tag("4")
    public void buttonGetToWorkIsDisplayed() {
        introScreen.buttonNextClick();
        introScreen.buttonNextClick();
        assertTrue(introScreenThirdPage.buttonNextEnable(), "Кнопка Приступить к работе не доступна");
    }
    @Test
    @DisplayName("Проверить что после прохождения обучения отображается поле поиска на главной странице")
    @Tag("5")
    public void mainPageTitleIsEnable() {
        introScreen.buttonNextClick();
        introScreen.buttonNextClick();
        introScreen.buttonNextClick();
        assertTrue(mainPage.searchFieldIsDisplayed(), "Поле поиска не отобразилось");
    }
    @Test
    @DisplayName("Проверить что после пропуска обучения отображается поле поиска на главной странице")
    @Tag("6")
    public void skipLearing() {
        introScreen.skipLearningClick();
        assertTrue(mainPage.searchFieldIsDisplayed(), "Поле поиска не отобразилось");
    }
    @Test
    @DisplayName("Проверить поиск на вкладке Новости")
    @Tag("7")
    public void requestSearch() {
        String actual = "Законы";
        introScreen.skipLearningClick();
        mainPage.setTextAtSearchField("Законы");
        mainPage.leftSearchButtonClick();
        assertEquals(actual,searchDocumentsPage.getSearchEditText(), "Введенный в поле поиск текст не совпадает с текстом в поле поиск");
    }
}
