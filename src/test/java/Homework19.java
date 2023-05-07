import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));

        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn () throws InterruptedException {
        WebElement deletedPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletedPlaylist.click();

    }

    public String getDeletedPlaylistMsg(){
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }



}