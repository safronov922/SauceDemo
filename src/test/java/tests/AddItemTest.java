package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pagefactorypages.LoginPage;
import pagefactorypages.ProductsPage;

public class AddItemTest extends BaseTest {
    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    LoginPage loginPage;
    ProductsPage productsPage;

    @Test
    public void addItemToBasketTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLogInPage();
        loginPage.inputLogin(USER_NAME);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickLogInButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickAddBikeLightButton();
        productsPage.clickShoppingContainer();
        Assert.assertEquals(productsPage.getItemName(), "Sauce Labs Bike Light");
        Assert.assertEquals(productsPage.getPrice(), "$9.99");
    }
}

