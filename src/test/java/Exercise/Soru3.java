package Exercise;

import com.github.javafaker.Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Soru3 extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {
        // 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='slider']")).isDisplayed());
        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        WebElement kayit= driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
        kayit.click();
        //5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        //6. Yanlış e-posta adresi ve şifre girin
        WebElement email = driver.findElement(By.xpath("(//*[@type='email'])[1]"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        Thread.sleep(2000);
        actions.click(email).sendKeys(faker.internet().emailAddress()).
                            sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                            .sendKeys(Keys.ENTER).perform();
        // 8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed());

    }
}
