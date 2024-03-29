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
    @Test
    @DisplayName("Проверить работу фильтра новостей, при выборе 1-го элемента")
    @Tag("8")
    public void newsFilter() {
        String actualFilterText = "Фильтр: Бухгалтер";
        introScreen.skipLearningClick();
        mainPage.newsClick();
        mainPage.filterButtonClick();
        mainPage.clickCheckBox(0);
        mainPage.appruvFilterButtonClick();
        assertEquals(actualFilterText,mainPage.getfilterButtonText(), "Текст фильтра не верный");
    }
    @Test
    @DisplayName("Проверить работу фильтра новостей, при выборе нескольких элементов элементов")
    @Tag("9")
    public void newsFilterFewCheck() {
        String actualFilterText = "Фильтр: Юрист, Закупки, Кадры";
        introScreen.skipLearningClick();
        mainPage.newsClick();
        mainPage.filterButtonClick();
        mainPage.clickCheckBox(1);
        mainPage.clickCheckBox(3);
        mainPage.clickCheckBox(4);
        mainPage.appruvFilterButtonClick();
        assertEquals(actualFilterText,mainPage.getfilterButtonText(), "Текст фильтра не верный");
    }
    @Test
    @DisplayName("Проверить отображения списка кодексов")
    @Tag("10")
    public void codecsIsDisplayed() {
        introScreen.skipLearningClick();
        mainPage.codecsClick();
        assertTrue(mainPage.codexListIsDisplayed(), "Список кодексов не появился");
    }
}
