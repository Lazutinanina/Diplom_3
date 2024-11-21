package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final By nameInputBox = By.xpath(".//label[text()='Имя']/..//input");
    private final By emailInputBox = By.xpath(".//label[text()='Email']/..//input");
    private final By passwordInputBox = By.xpath(".//*[text()='Пароль']/..//input");
    private final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By incorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");
    private final By signInLink = By.linkText("Войти");
    private final By loginHeader = By.xpath(".//h2[text() = 'Вход']");

    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("получение инпута с полем для ввода имени")
    public WebElement getNameFieldForRegister() {
        return driver.findElements(nameInputBox).get(0);
    }

    @Step("получение инпута с полем для ввода почты")
    public WebElement getEmailFieldForRegister() {
        return driver.findElements(emailInputBox).get(0);
    }

    @Step("получение инпута с полем для ввода пароля")
    public WebElement getPasswordFieldForRegister() {
        return driver.findElements(passwordInputBox).get(0);
    }

    @Step("ввод имени пользователя в поле с именем")
    public void setNameForRegister(String name) {
        getNameFieldForRegister().sendKeys(name);
    }

    @Step("ввод почты пользователя в поле с почтой")
    public void setEmailFieldForRegister(String email) {
        getEmailFieldForRegister().sendKeys(email);
    }

    @Step("ввод пароля пользователя в поле с паролем")
    public void setPasswordFieldForRegister(String password) {
        getPasswordFieldForRegister().sendKeys(password);
    }

    @Step("клик по кнопке 'Зарегистрироваться' на странице с регистрацией")
    public void clickButtonForRegister() {
        driver.findElement(signUpButton).click();
    }
    @Step("ожидание страницы входа")
    public void waitLoginHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(loginHeader).getText() != null
                   && !driver.findElement(loginHeader).getText().isEmpty()
                 ));
    }
    @Step("клик по кнопке 'Войти' на странице с регистрацией")
    public void clickButtonForLogin() {
        driver.findElement(signInLink).click();
    }

    @Step("получение текста при неверной аутентификации пользователя")
    public String getTestForIncorrectPassword() {
        return driver.findElement(incorrectPassword).getText();
    }
}
