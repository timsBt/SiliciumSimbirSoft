import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestCase2 {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void SeyUp() {
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
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service" , error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
