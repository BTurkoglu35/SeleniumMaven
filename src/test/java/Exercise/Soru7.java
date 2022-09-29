package Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.sql.Driver;

public class Soru7 extends TestBaseBeforeAfter {
    /*
    1. Tarayıcıyı başlatın
2. 'http://automationexercise.com' url'sine gidin
3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
4. 'Test Vakaları' düğmesine tıklayın
5. Kullanıcının test senaryoları sayfasına başarıyla yönlendirildiğini doğrulayın
     */

    @Test
    public void test1(){
        driver.get("http://automationexercise.com");

        WebElement anasayfa= driver.findElement(By.cssSelector("html[lang='en']"));
        Assert.assertTrue(anasayfa.isDisplayed());

        driver.findElement(By.xpath("(//*[@class='fa fa-list'])[1]")).click();
        WebElement testCases= driver.findElement(By.cssSelector(".col-sm-9.col-sm-offset-1"));
        Assert.assertTrue(testCases.isDisplayed());
    }
}
