package tests;

import javafx.scene.shape.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactorypages.LinkedInPage;
import pagefactorypages.LoginPage;
import pagefactorypages.ProductsPage;
import utilits.RetryAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoginTest extends BaseTest {

    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    LoginPage loginPage;

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void logInTest() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.openLogInPage()
                .inputLogin(USER_NAME)
                .inputPassword(PASSWORD)
                .clickLogInButton();
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenshot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot.png"),sourceFile);
        Assert.assertEquals(loginPage.getPageName(), "PRODUCTS");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void checkLogoTest() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.openLogInPage()
                .inputLogin(USER_NAME)
                .inputPassword(PASSWORD)
                .clickLogInButton();
        driverManager.removeTimeout();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnLinkedInButton();
        boolean logoDiplayed= productsPage.switchToNewTab().logoIconWait();
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenshot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot2.png"),sourceFile);
        Assert.assertTrue(logoDiplayed, "Logo don't displayed");
    }
}