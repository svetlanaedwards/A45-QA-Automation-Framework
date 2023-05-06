import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;




public class Homework19 extends BaseTest{

    @Test

    public void deletePlaylist() throws InterruptedException {
        String deletedPlaylistMsg = "Deleted playlist";
        login ("svetlana.edwards@testpro.io", "te$t$tudent");
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertTrue(getDeletedPlaylistMsg().contains(deletedPlaylistMsg));

    }

    public void openPlaylist(){

        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));

        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn () throws InterruptedException {
        WebElement deletedPlaylist = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletedPlaylist.click();
        Thread.sleep(2000);
    }

    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();
    }



}