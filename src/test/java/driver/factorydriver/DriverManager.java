package driver.factorydriver;

import org.openqa.selenium.WebDriver;
import staticdata.WebTimeouts;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public abstract class  DriverManager {
    protected WebDriver driver;
    public abstract void createDriver() throws MalformedURLException;
    public WebDriver getDriver(){
        return driver;
    }
    public void setTimeout(){
        driver.manage().timeouts().pageLoadTimeout(WebTimeouts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(WebTimeouts.SCRIPTS_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WebTimeouts.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
    }
    public void removeTimeout(){
        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
    }
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
    public void quitBrowser() {
        driver.quit();
    }
}
