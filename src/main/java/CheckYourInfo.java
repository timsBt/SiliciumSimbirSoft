import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckYourInfo {

    private WebDriver driver;

    public CheckYourInfo (WebDriver driver) {
        this.driver = driver;
    }

    private By firsName = By.xpath("//input[@id='first-name']");
    private By lastName = By.xpath("//input[@id='last-name']");
    private By postalCode = By.xpath("//input[@id='postal-code']");
    private By continium = By.xpath("//input[@id='continue']");

    public CheckYourInfo typeFirstname (String name){
        driver.findElement(firsName).sendKeys(name);
        return this;
    }

    public CheckYourInfo typeLastname (String name){
        driver.findElement(lastName).sendKeys(name);
        return this;
    }

    public CheckYourInfo typePostalcode (String code){
        driver.findElement(postalCode).sendKeys(code);
        return this;
    }

    public CheckOverview yourOver (String firstname, String lastname, String code){
        this.typeFirstname(firstname);
        this.typeLastname(lastname);
        this.typePostalcode(code);
        driver.findElement(continium).click();
        return new CheckOverview(driver);

    }

}