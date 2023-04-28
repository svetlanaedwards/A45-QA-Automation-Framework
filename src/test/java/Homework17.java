import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {
        String newSongAddedNotificationText = "Added 1 song into";

        navigateToPage();
        provideEmail("svetlana.edwards@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        searchSong("Pluto");
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));
    }

    public void searchSong (String songTitleKeyword) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.click();
        searchField.sendKeys(songTitleKeyword);
        Thread.sleep(2000);
    }
        public void clickViewAllBtn() throws InterruptedException {
            WebElement viewAllSearchResult = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/h1/button"));
            // #searchExcerptsWrapper > div > div > section.songs > h1 > button
            // //*[@id="searchExcerptsWrapper"]/div/div/section[1]/h1/button
            viewAllSearchResult.click();
            Thread.sleep(2000);
        }

        public void selectFirstSongResult() throws InterruptedException {
                WebElement firstSongResult = driver.findElement(By.cssSelector("section#songResultsWrapper tr.song-item td.title"));
                firstSongResult.click();
                Thread.sleep(2000);
            }

            public void clickAddToBtn() throws InterruptedException {
                    WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
                    addToBtn.click();
                    Thread.sleep(2000);
                }

                public void choosePlaylist() throws InterruptedException {
                        WebElement playlistElement = driver.findElement(By.xpath
                                ("//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]"));


                playlistElement.click();
                Thread.sleep( 2000);
                    }

            public String getNotificationText(){
                WebElement notificationElement = driver.findElement(By.cssSelector("div.success.show"));
                return notificationElement.getText();
}
}