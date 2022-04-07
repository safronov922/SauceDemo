package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactorypages.LoginPage;
import pagefactorypages.ProductsPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddItemTest extends BaseTest {
    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    LoginPage loginPage;
    ProductsPage productsPage;

    @Test
    public void addItemToBasketTest() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.openLogInPage();
        loginPage.inputLogin(USER_NAME);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickLogInButton();
        productsPage = new ProductsPage(driver);
        productsPage.clickAddBikeLightButton();
        productsPage.clickShoppingContainer();
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenshot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot1.png"),sourceFile);
        Assert.assertEquals(productsPage.getItemName(), "Sauce Labs Bike Light");
        Assert.assertEquals(productsPage.getPrice(), "$9.99");
    }
}

