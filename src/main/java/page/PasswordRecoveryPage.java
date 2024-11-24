package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final By loginButton = By.linkText("Войти");
    private final WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать по кнопке 'Восстановить пароль'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
