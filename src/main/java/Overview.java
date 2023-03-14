import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Overview {

    private WebDriver driver;

    public Overview(WebDriver driver) {
        this.driver = driver;
    }

    private By finishInput = By.cssSelector("#finish");

    public Complete finish () {
        driver.findElement(finishInput).click();
        return new Complete(driver);
    }




}
