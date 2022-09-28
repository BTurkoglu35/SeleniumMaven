package Exercise;

import com.github.javafaker.Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru4 extends TestBaseBeforeAfter {
    Faker faker = new Faker();

    @Test
    public void test1() {

    // 1. Tarayıcıyı başlatın
    // 2. 'http://automationexercise.com' url'sine gidin
       driver.get("http://automationexercise.com");
    // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='slider']")).isDisplayed());
    // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        WebElement kayit= driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        kayit.click();
    // 5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
    // 6. Doğru e-posta adresini ve şifreyi girin
        /*
        WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
        String email = faker.internet().emailAddress();
        actions.click(name).sendKeys("Emre")
                .sendKeys(Keys.TAB).sendKeys("esulukan34@gmail.com")
                .sendKeys(Keys.ENTER).perform();
        WebElement account = driver.findElement(By.xpath("(//*[@class='top'])[1]"));
        String isim = faker.internet().emailAddress();
        actions.click(account)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("12345678")
                .sendKeys(Keys.TAB).sendKeys("5")
                .sendKeys(Keys.TAB).sendKeys("January")
                .sendKeys(Keys.TAB).sendKeys("1986")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("United State").sendKeys(Keys.TAB)
                .sendKeys("Texas").sendKeys(Keys.TAB)
                .sendKeys("Dallas").sendKeys(Keys.TAB)
                .sendKeys("10100").sendKeys(Keys.TAB)
                .sendKeys("5555555555")
                .sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

         */
        WebElement kullaniciAdi =driver.findElement(By.xpath("(//*[@name ='email'])[1]"));
        kullaniciAdi.sendKeys("esulukan34@gmail.com");
        driver.findElement(By.xpath("(//*[@name ='password'])")).sendKeys("12345678");

    // 7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@type ='submit'])[1]")).click();

    // 8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed();

    // 9. 'Çıkış' düğmesini tıklayın
        driver.findElement(By.xpath("(//*[@style='color:brown;'])[1]")).click();

    // 10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın
        driver.findElement(By.xpath("(//*[@name ='email'])[1]")).isDisplayed();

    }

}
