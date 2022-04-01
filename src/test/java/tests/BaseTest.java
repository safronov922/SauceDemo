package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import staticdata.WebTimeouts;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        setTimeout();
    }

    public void setTimeout(){
        driver.manage().timeouts().pageLoadTimeout(WebTimeouts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(WebTimeouts.SCRIPTS_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WebTimeouts.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
    }
    public void removeTimeout(){
        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
