import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOverview {

    private WebDriver driver;

    public CheckOverview(WebDriver driver) {
        this.driver = driver;
    }

    private By finishInput = By.cssSelector("#finish");

    public Complete finish () {
        driver.findElement(finishInput).click();
        return new Complete(driver);
    }

}