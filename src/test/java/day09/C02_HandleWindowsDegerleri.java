package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindowsDegerleri {



    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
       // 9- Sayfaları Kapatalım
        driver.quit();

    }
    @Test
    public void test(){
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();//1. adim icinde bulunulan pencerenin hash kodu alinir
        //2- Url'nin amazon içerdiğini test edelim
        String actualUrl=driver.getCurrentUrl();
        String str="amazon";
        Assert.assertTrue(actualUrl.contains(str));

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);//yeni bir pencere acmak icn kullanilir
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();
        /*
        eger bize verilen task'de sayfalr arsi gecis varsa her driver.get methodundan sonra driverin window handle
        degerini string bir degiskene atariz. Sonrasinda farkli bir sayfaya yada sekmeye gittikten sonra tekrar ilk sayfaya donmemiz
        istenirse  string degere atadigimz window handle degerleri ile yapabiliriz.
         */
        //4- title'in Best Buy içerdiğini test edelim
       String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
       String str1="Best Buy";
       Assert.assertTrue(actualTitle.contains(str1));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);//handle degeri stringe atanmis sayfalar arsai gecis yapmak icin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

        // 6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String kelime="java";
        Assert.assertTrue(aramaSonucu.getText().contains(kelime));
        // 7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);
        // 8- Logonun görünürlüğünü test edelim
        WebElement logo=driver.findElement(By.className("logo"));
        Assert.assertTrue(logo.isDisplayed());














    }



















}
