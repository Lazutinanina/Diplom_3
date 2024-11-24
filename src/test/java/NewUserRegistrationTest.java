import io.qameta.allure.junit4.DisplayName;
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


import static constants.Endpoints.*;
import static org.junit.Assert.assertEquals;

public class NewUserRegistrationTest {
    private WebDriver webDriver;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected User user;

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
        webDriver.get(REGISTER_URL);
        user = GeneratorUser.getUser();
        registrationPage = new RegistrationPage(webDriver);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @After
    public void closeBrowser() {
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
        String actual = webDriver.getCurrentUrl();

        assertEquals(LOGIN_URL, actual);
    }




}
