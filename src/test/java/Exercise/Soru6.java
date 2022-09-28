package Exercise;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Soru6 extends TestBaseBeforeAfter {

    //   1. Tarayıcıyı başlatın
    // 2. 'http://automationexercise.com' url'sine gidin

    @Test
    public void test() {
        driver.get("http://automationexercise.com");
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='slider']")).isDisplayed());
        // 4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
        // 5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        WebElement getInTouch = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(getInTouch.isDisplayed());
        // 6. Adı, e-posta adresini, konuyu ve mesajı girin
        WebElement name= driver.findElement(By.xpath("//input[@name='name']"));
        Faker faker = new Faker();
        actions.click(name).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys("sayfa giris testleri").sendKeys(Keys.TAB).
                sendKeys("sayfayi dvkdkp").perform();

        // 7. Dosya yükle
       driver.findElement(By.xpath("//*[@name='upload_file']")).sendKeys("C:\\Users\\ASUS\\IdeaProjects\\com.Batch81Maven\\src\\test\\java\\Exercise\\redCar.png");
        // 8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@name='submit']")).sendKeys(Keys.ENTER);

        // 9. Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();
        // 10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        WebElement mesaj = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(mesaj.isDisplayed());
        // 11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='btn btn-success']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
    }
}