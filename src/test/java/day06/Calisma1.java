package day06;

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

public class Calisma1 {

    WebDriver driver;

    @Before
    public void setUp() {
        //Tarayiciyi baslatin
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
     WebElement anasayfa=driver.findElement(By.xpath("(//html[@lang='en'])[1]"));
     Assert.assertTrue(anasayfa.isDisplayed());
       // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
      driver.findElement(By.xpath("//*[@href='/login']")).click();
      //  5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
      WebElement hesapYazisi=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(hesapYazisi.isDisplayed());
      //6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("hayat@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("1245");
        //7. 'Giriş' düğmesini tıklayın
       driver.findElement(By.xpath("//*[text()='Login']")).click();
        //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement loginInAs=driver.findElement(By.xpath("//*[text()=' Logged in as '] "));
        Assert.assertTrue(loginInAs.isDisplayed());
        //9. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath(" //*[text()=' Delete Account']")).click();
        //10. 'HESAP SİLİNDİ!' görünür
        WebElement hesapSil=driver.findElement(By.xpath("(//*[text()='Delete Account'])[1]"));
        Assert.assertTrue(hesapSil.isDisplayed());}

      @After
       public void tearDown(){
          driver.close();
        }





}
