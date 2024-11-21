import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.GeneratorUser;
import user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.LoginPage;
import page.RegistrationPage;
import user.UserClient;

import java.time.Duration;

import static constants.Endpoints.BASE_URI;
import static constants.Endpoints.ENDPOINT_FOR_LOGIN_USER;
import static org.junit.Assert.assertEquals;

public class NewUserRegistrationTest {
    private WebDriver webDriver;
    private String actual;
    private final String expected = BASE_URI + ENDPOINT_FOR_LOGIN_USER;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected User user;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
        user = GeneratorUser.getUser();
        registrationPage = new RegistrationPage(webDriver);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @After
    public void CloseBrowser() {
        UserClient.deleteUser(user);
        webDriver.quit();
    }

    @Test
    @DisplayName("Регистрация валидного пользователя")
    public void registerValidUser() {
        registrationPage.setNameForRegister(user.getName());
        registrationPage.setEmailFieldForRegister(user.getEmail());
        registrationPage.setPasswordFieldForRegister(user.getPassword());
        registrationPage.clickButtonForRegister();
        registrationPage.waitLoginHeader();
        actual = webDriver.getCurrentUrl();

        assertEquals(expected, actual);
    }




}
