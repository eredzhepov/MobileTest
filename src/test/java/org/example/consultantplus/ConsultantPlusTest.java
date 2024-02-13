package org.example.consultantplus;

import org.example.consultantplus.pages.IntroScreen;
import org.example.consultantplus.pages.IntroScreenSecondPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsultantPlusTest extends BaseTest{

    private IntroScreen introScreen;
    private IntroScreenSecondPage introScreenSecondPage;
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        introScreen = new IntroScreen(getDriver());
        introScreenSecondPage = new IntroScreenSecondPage(getDriver());
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
    }@Test
    @DisplayName("Проверка соответсвия title")
    @Tag("3")
    public void checkTitle() {
        String title = "Работа без интернета";
        introScreen.buttonNextClick();
        assertEquals(introScreenSecondPage.getTitleText(), title, "Заголовки не соответстуют");
    }
}
