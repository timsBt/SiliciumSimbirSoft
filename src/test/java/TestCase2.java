import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestCase2 {

    private WebDriver driver;
    private LoginPage loginPage;



    @BeforeEach
    public void SetUuuup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.invalidLogin("test","test");
    }



    @Test
    public void errorMessage(){
        String error = loginPage.errorText();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service" , error);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}


