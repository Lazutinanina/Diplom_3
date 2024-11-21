import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class ConstructorTest extends TestBase {

    private final List<String> ingredientsBurger = Arrays.asList("Булки", "Соусы", "Начинки");


    @Test
    @DisplayName("Переход по разделам Конструктора, булки")
    public void clickSectionBunTest() {
        homePage.clickBun();
        String actual = homePage.getBunSectionClassName();
        assertTrue(ingredientsBurger.contains(actual));
    }

    @Test
    @DisplayName("Переход по разделам Конструктора, соусы")
    public void clickSectionSauceTest() {
        homePage.clickSauce();
        String actual = homePage.getSauceSectionClassName();
        assertTrue(ingredientsBurger.contains(actual));
    }


    @Test
    @DisplayName("Переход по разделам Конструктора, начинки")
    public void clickSectionFillingTest() {
        homePage.clickFilling();
        String actual = homePage.getFillingSectionClassName();
        assertTrue(ingredientsBurger.contains(actual));
    }



}

