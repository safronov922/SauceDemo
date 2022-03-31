package pagefactorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInPage extends BasePage {
    @FindBy(xpath = "//icon[@data-test-id='nav-logo']")
    WebElement logoIcon;

    public LinkedInPage(WebDriver driver) {
        super(driver);
    }

    public boolean logoIconWait() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(logoIcon));
        return logoIcon.isDisplayed();
    }
}
