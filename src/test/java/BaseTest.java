import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = "";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = BaseURL;
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public static void navigateToPage() {
        driver.get(url);
    }

    public void login (String email, String password) {

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
}










