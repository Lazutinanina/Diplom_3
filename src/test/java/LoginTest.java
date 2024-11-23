import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


import static constants.Endpoints.BASE_URL;
import static org.junit.Assert.assertEquals;

public class LoginTest extends TestBase {


    @Test
    @DisplayName("Авторизация пользователя, Login")
    public void loginTest() {
        homePage.clickButtonLogin();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();
        String actual = webDriver.getCurrentUrl();
        assertEquals(BASE_URL, actual);
    }

    @Test
    @DisplayName("Авторизация пользователя PersonalAccount")
    public void loginPersonalAccountTest() {
        homePage.clickPersonalAccount();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();
        String actual = webDriver.getCurrentUrl();
        assertEquals(BASE_URL, actual);
    }

    @Test
    @DisplayName("Авторизация пользователя со страницы регистрации")
    public void loginFromRegisterTest3() {
        homePage.clickPersonalAccount();
        loginPage.clickButtonRegister();
        registrationPage.clickButtonForLogin();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();
        String actual = webDriver.getCurrentUrl();
        assertEquals(BASE_URL, actual);
    }

    @Test
    @DisplayName("Авторизация пользователя, со страницы восстановления пароля")
    public void loginRecoveryPasswordTest() {
        homePage.clickPersonalAccount();
        loginPage.clickButtonForRecoveryPassword();
        passwordRecoveryPage.clickLoginButton();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();
        String actual = webDriver.getCurrentUrl();
        assertEquals(BASE_URL, actual);
    }


}
