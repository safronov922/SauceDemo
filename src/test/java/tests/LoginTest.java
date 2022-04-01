package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactorypages.LinkedInPage;
import pagefactorypages.LoginPage;
import pagefactorypages.ProductsPage;

public class LoginTest extends BaseTest {

    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    LoginPage loginPage;

    @Test
    public void logInTest() {
        loginPage = new LoginPage(driver);
        loginPage.openLogInPage();
        loginPage.inputLogin(USER_NAME);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickLogInButton();
        Assert.assertEquals(loginPage.getPageName(), "PRODUCTS");
    }

    @Test
    public void checkLogoTest() {
        loginPage = new LoginPage(driver);
        loginPage.openLogInPage();
        loginPage.inputLogin(USER_NAME);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickLogInButton();
        removeTimeout();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnLinkedInButton();
        productsPage.switchToNewTab();
        LinkedInPage linkedInPage = new LinkedInPage(driver);
        Assert.assertTrue(linkedInPage.logoIconWait(), "Logo don't displayed");
    }
}