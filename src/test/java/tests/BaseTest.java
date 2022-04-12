package tests;

import driver.factorydriver.DriverFactory;
import driver.factorydriver.DriverManager;
import driver.factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import staticdata.WebTimeouts;
import utilits.PropertiesManager;
import utilits.TestListeners;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
@Listeners(TestListeners.class)
public class BaseTest {
    private static final String USER_NAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        DriverType driverType = null;
        if(browser.equals("chrome")){
            driverType = DriverType.CHROME;
        }
        if (browser.equals("firefox")){
            driverType = DriverType.MOZILLA;
        }
        driverManager = driverFactory.getManager(driverType);
        driverManager.createDriver();
        driver =driverManager.getDriver();
        driverManager.maximizeWindow();
        driverManager.setTimeout();
    }
    public WebDriver getDriver(){
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitBrowser();
    }
}
