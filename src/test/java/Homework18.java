import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;



public class Homework18 extends BaseTest {

@Test

 public void playASongTest() throws InterruptedException {
     login ("svetlana.edwards@testpro.io", "te$t$tudent");
     playSong();
     Assert.assertTrue(isSongPlaying());
 }

 public void playSong() {
     WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
     WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

     playNextButton.click();
     playButton.click();
 }

 public boolean isSongPlaying(){
    WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
    return soundBar.isDisplayed();
 }
}



