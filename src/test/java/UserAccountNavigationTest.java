import constants.ButtonConstructor;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static constants.ButtonConstructor.CONSTRUCTOR;
import static constants.ButtonConstructor.LOGO_STELLAR_BURGER;
import static constants.Endpoints.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UserAccountNavigationTest extends TestBase {
    private final ButtonConstructor buttonConstructor;

    public UserAccountNavigationTest(ButtonConstructor buttonConstructor) {
        this.buttonConstructor = buttonConstructor;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {CONSTRUCTOR},
                {LOGO_STELLAR_BURGER}
        };
    }


    @Test
    @DisplayName("Переход в Личный кабинет авторизованным пользователем")
    public void personalAreaButtonWithAuthUser() {
        loginPersonalAccount();
        homePage.clickPersonalAccount();
        personalAccountPage.waitLoadingPage();
        assertEquals(user.getName(), personalAccountPage.getUserName());
        assertEquals(user.getEmail().toLowerCase(), personalAccountPage.getUserLogin());
    }

    @Test
    @DisplayName("Выход из Личного кабинета")
    public void exitFromLk() {
        loginPersonalAccount();
        toPersonalAccountAfterLogin();

        personalAccountPage.clickExit();
        loginPage.waitLoadHeader();

        assertEquals(LOGIN_URL, webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из ЛК в Конструктор")
    public void transitionToConstructorFromLk() {
        personalAccountPage.transitionToPersonalAccount(homePage, loginPage, user);
        personalAccountPage.waitLoadingPage();
        personalAccountPage.changeButton(buttonConstructor);
        assertEquals(BASE_URL, webDriver.getCurrentUrl());
    }

    @Step("Авторизация")
    private void loginPersonalAccount() {
        homePage.clickPersonalAccount();
        loginPage.waitLoadHeader();
        loginPage.setEmailField(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickButtonLogin();
    }

    @Step("Переход в ЛК после авторизации")
    private void toPersonalAccountAfterLogin() {
        homePage.clickPersonalAccount();
        personalAccountPage.waitLoadingPage();
    }
}
