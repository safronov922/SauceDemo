package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactorypages.LoginPage;

public class LoginTest extends BaseTest {

    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    LoginPage loginPage;

    @Test
    public void logInTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLogInPage();
        loginPage.inputLogin(USER_NAME);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickLogInButton();
        Assert.assertEquals(loginPage.getPageName(), "PRODUCTS");
    }
}