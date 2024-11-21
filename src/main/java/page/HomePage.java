package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By orderPlaceButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By profileEnterButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By accountEnterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By burgerAssembleTitle = By.xpath(".//*[text()='Соберите бургер']");
    private final By menuBuns = By.xpath(".//span[text()='Булки']/..");
    public final By menuSauces = By.xpath(".//span[text()='Соусы']/..");
    private final By menuFillings = By.xpath(".//span[text()='Начинки']/..");
    private final By homePageHeader = By.xpath(".//*[@class='active']");


    private final By loginHeader = By.xpath(".//h2[text() = 'Вход']");
    public void waitLoadHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(homePageHeader).isEnabled()
        ));
    }


    @Step("Нажать по кнопке 'Войти в аккаунт' на главной странице")
    public void clickButtonLogin() {
        waitLoadHeader();
        driver.findElement(accountEnterButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(loginHeader).getText() != null
                && !driver.findElement(loginHeader).getText().isEmpty()
        ));
    }

    @Step("Нажать по ссылке 'Личный кабинет' на главной странице")
    public void clickPersonalAccount() {
        waitLoadHeader();
        driver.findElement(profileEnterButton).click();
    }

    @Step("Нажать по кнопке 'Соусы' на главной странице")
    public void clickSauce() {
        waitLoadHeader();
        driver.findElement(menuSauces).click();
    }

    @Step("Нажать по кнопке 'Булки' на главной странице")
    public void clickBun() {
        waitLoadHeader();
        clickSauce();
        driver.findElement(menuBuns).click();
    }

    @Step("Нажать по кнопке 'Начинки' на главной странице")
    public void clickFilling() {
        waitLoadHeader();
        driver.findElement(menuFillings).click();
    }



    public WebElement getBunSection(){
        return driver.findElement(menuBuns);
    }
    public WebElement getSauceSection(){
        return driver.findElement(menuSauces);
    }
    public WebElement getFillingSection(){
        return driver.findElement(menuFillings);
    }

    public String getBunSectionClassName() {
        return getBunSection().getText();
    }
    public String getSauceSectionClassName() {
        return getSauceSection().getText();
    }
    public String getFillingSectionClassName() {
        return getFillingSection().getText();
    }


}
