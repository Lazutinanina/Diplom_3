import user.GeneratorUser;
import user.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import page.*;
import io.qameta.allure.junit4.DisplayName;
import user.UserClient;

import java.time.Duration;


public class TestBase {
    protected WebDriver webDriver;
    protected User user;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected PasswordRecoveryPage passwordRecoveryPage;
    protected PersonalAccountPage personalAccountPage;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.get("https://stellarburgers.nomoreparties.site");
        registrationPage = new RegistrationPage(webDriver);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        personalAccountPage = new PersonalAccountPage(webDriver);
        passwordRecoveryPage = new PasswordRecoveryPage(webDriver);
        user = GeneratorUser.getUser();
        UserClient.createUser(user);
    }

    @After
    @DisplayName("Удаление user и закрытие браузера")
    public void deleteUserAndCloseBrowser() {
        System.out.println("Пользователь " + user.getName() + " Был удален");
        UserClient.deleteUser(user);
        webDriver.quit();
    }


}
