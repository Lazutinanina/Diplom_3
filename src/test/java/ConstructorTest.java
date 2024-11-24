import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ConstructorTest extends TestBase {

    private final String selectedSectionClassPart = "current";

    @Test
    @DisplayName("Переход по разделам Конструктора, булки")
    public void clickSectionBunTest() {
        homePage.clickBun();
        String className = homePage.getBunSectionClassName();
        assertTrue(className.contains(selectedSectionClassPart));
    }

    @Test
    @DisplayName("Переход по разделам Конструктора, соусы")
    public void clickSectionSauceTest() {
        homePage.clickSauce();
        String className = homePage.getSauceSectionClassName();
        assertTrue(className.contains(selectedSectionClassPart));
    }

    @Test
    @DisplayName("Переход по разделам Конструктора, начинки")
    public void clickSectionFillingTest() {
        homePage.clickFilling();
        String className = homePage.getFillingSectionClassName();
        assertTrue(className.contains(selectedSectionClassPart));
    }



}

