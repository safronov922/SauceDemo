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

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driverManager = driverFactory.getManager(DriverType.REMOTE);
        driverManager.createDriver();
        driver =driverManager.getDriver();
        driverManager.maximizeWindow();
        driverManager.setTimeout();
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitBrowser();
    }
}
