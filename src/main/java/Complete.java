import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Complete {

    private WebDriver driver;

    public Complete (WebDriver driver) {
        this.driver = driver;
    }

    private By text = By.cssSelector(".complete-header");

    public String textCheck (){
        return driver.findElement(text).getText();
    }


}
