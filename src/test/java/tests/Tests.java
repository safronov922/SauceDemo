package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrls;

public class Tests extends BaseTest {
    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @Test
    public void getLocatorsTest() {
        //Open index page
        driver.get(WebUrls.BASE_URL);
        //Add users name
        driver.findElement(By.id("user-name")).sendKeys(USER_NAME);
        //Add users password
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        // Log in
        driver.findElement(By.id("login-button")).click();
        //Add item to basket
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-bike-light']")).click();
        //Open basket

        driver.findElement(By.className("shopping_cart_container")).click();
        //Check item name

        Assert.assertEquals("Sauce Labs Bike Light", "Sauce Labs Bike Light");
        //Check item price
        Assert.assertEquals(9.99, 9.99);

    }
}
