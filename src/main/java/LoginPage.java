import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginInput = By.id("login-button");
    private By error = By.cssSelector("div.error-message-container.error");

    public LoginPage typeName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }
    public LoginPage typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public Products login (String name, String password){
        this.typeName(name);
        this.typePassword(password);
        driver.findElement(loginInput).click();
        return new Products(driver);
    }

    public LoginPage invalidLogin (String name, String password){
        this.typeName(name);
        this.typePassword(password);
        driver.findElement(loginInput).click();
        return new LoginPage(driver);
    }

    public String errorText (){
        return driver.findElement(error).getText();
    }

}





