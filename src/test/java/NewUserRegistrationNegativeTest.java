import io.qameta.allure.junit4.DisplayName;
import user.GeneratorUser;
import user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.HomePage;
import page.LoginPage;
import page.RegistrationPage;

import static constants.Endpoints.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NewUserRegistrationNegativeTest {
    private WebDriver webDriver;
    protected RegistrationPage registrationPage;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected User user;
    private final String password;

    public NewUserRegistrationNegativeTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"!"},
                {"a"},
                {"aaaaa"},
                {"12345"}
        };
    }

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
        webDriver.quit();
    }
    @Test
    @DisplayName("Регистрация пользователя с паролем меньше 6 символов")
    public void registerInvalidUser() {
        registrationPage.setNameForRegister(user.getName());
        registrationPage.setEmailFieldForRegister(user.getEmail());
        registrationPage.setPasswordFieldForRegister(password);
        registrationPage.clickButtonForRegister();

        String actual = registrationPage.getTestForIncorrectPassword();

        assertEquals("Некорректный пароль", actual);
    }
}
