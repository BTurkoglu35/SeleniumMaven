package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Calisma {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test()  {
        //  2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
     //  3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        WebElement anasayfa =driver.findElement(By.xpath("//*[@lang='en']"));
        Assert.assertTrue(anasayfa.isDisplayed());
     //  4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();
     //  5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
     WebElement girisYazisi= driver.findElement(By.xpath("//*[text()='Login to your account']"));
     //  6. Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("cdkkvks@cdd");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("sdfdmmd");
     //  7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Login']")).click();
     //  8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
       WebElement sonucYazisi = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
       Assert.assertTrue(sonucYazisi.isDisplayed());








    }








}
