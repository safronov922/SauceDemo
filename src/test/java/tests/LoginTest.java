package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
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
        // productsPage.switchToNewTab(); у меня вроде как автоматом вкладка открывается, но метод все равто какой-то не рабочий  меня
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        WebElement logoIcon = driver.findElement(By.xpath("//icon[@data-test-id='nav-logo']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(logoIcon));
        boolean logoIconDisplayed = logoIcon.isDisplayed();
        Assert.assertTrue(logoIconDisplayed,"Logo don't displayed");
// по итогу не работает, я не понимаю почему он не хочет ждать ,не находит вебэлемент ( я пробовал и локатор и разные локаторы)
    }
}