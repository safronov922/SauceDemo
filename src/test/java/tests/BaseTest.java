package tests;

import driver.factorydriver.DriverFactory;
import driver.factorydriver.DriverManager;
import driver.factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import staticdata.WebTimeouts;
import utilits.PropertiesManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driverManager = driverFactory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver =driverManager.getDriver();
        driverManager.maximizeWindow();
        driverManager.setTimeout();
        driverManager.removeTimeout();
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitBrowser();
    }
}
