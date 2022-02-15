package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import staticdata.WebUrls;
import tests.BaseTest;

public class Locators extends BaseTest {


    @Test
    public void getLocatorsTest() {
        driver.get(WebUrls.BASE_URL);
        WebElement classN = driver.findElement(By.className("login_password"));
        WebElement tagName = driver.findElement(By.tagName("form"));
        WebElement cssClass = driver.findElement(By.cssSelector(".bot_column"));
        WebElement cssId = driver.findElement(By.cssSelector("#login-button"));
        WebElement tagN = driver.findElement(By.cssSelector("div"));
        WebElement attribute1 = driver.findElement((By.cssSelector("[data-test^='log']")));
        WebElement attribute2 = driver.findElement((By.cssSelector("[data-test$=ord]")));
        WebElement attribute3 = driver.findElement((By.cssSelector("[data-test*=rn]")));
        WebElement attribute4 = driver.findElement((By.cssSelector("div.form_group:first-child")));
        WebElement attribute5 = driver.findElement((By.cssSelector("div.form_group:nth-child(1)")));
        WebElement xpathAttribute = driver.findElement((By.xpath("//div[@class='error-message-container']")));
        WebElement xpathText = driver.findElement(By.xpath("//h4[text()='Password for all users:']"));
        WebElement xpathContains = driver.findElement(By.xpath("//h4[contains(text(),'are')]"));
        WebElement xpathContains2 = driver.findElement(By.xpath("//div[contains(@class,'mess')]"));
        WebElement xpathAncestor = driver.findElement(By.xpath("//*[text()='standard_user']//ancestor::h4"));
        WebElement xpathParent = driver.findElement(By.xpath("//*[text()='standard_user']//parent::div"));
        WebElement xpathAnd = driver.findElement(By.xpath("//input[@class='submit-button btn_action' and @name='login-button']"));
        //Add users name
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Add users password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Log in
        driver.findElement(By.id("login-button")).click();
        WebElement linktext = driver.findElement(By.linkText("Reset App State"));
        WebElement partiallinktext = driver.findElement(By.partialLinkText("Twit"));

    }
}
