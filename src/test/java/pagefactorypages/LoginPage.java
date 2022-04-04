package pagefactorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import staticdata.WebUrls;

public class LoginPage extends BasePage {


    @FindBy(id = "user-name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    @FindBy(className = "title")
    private WebElement pageName;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUrlLoaded(){
        return driver.getCurrentUrl().equals(WebUrls.BASE_URL);
    }

    public LoginPage openLogInPage() {
        driver.get(WebUrls.BASE_URL);
        return this;
    }

    public LoginPage inputLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public ProductsPage clickLogInButton() {
        logInButton.click();
        return new ProductsPage(driver);
    }

    public String getPageName() {
        return pageName.getText();
    }

}
