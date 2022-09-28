package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev2 extends TestBaseBeforeAfter {
    /*
    Bir Class olusturalim KeyboardActions2


     */

    @Test
    public void name() throws InterruptedException {
        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
       // videoyu izlemek icin Play tusuna basin
        WebElement youtubeIframe= driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(youtubeIframe);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        Thread.sleep(2000);


        //videoyu calistirdiginizi test edin
        WebElement duraklatButonu = driver.findElement(By.xpath("//*[@class='ytp-title-channel-logo']"));
        Assert.assertTrue(duraklatButonu.isDisplayed());
    }
}
