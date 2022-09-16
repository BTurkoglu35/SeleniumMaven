package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    static WebDriver driver;

    @BeforeClass
    public static  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasina git
        driver.get("https://amazon.com");
    }

    @Test
    public void test1(){

       //- url'in "amazon" icergini test et
        String actualUrl=driver.getCurrentUrl();
        String aranaKelime="amazon";
        Assert.assertTrue(actualUrl.contains(aranaKelime));


    }
    @Test
    public void test2(){
      //  b-title'in facebook icermedigini test edelim
        String actualTitle=driver.getTitle();
        String arananStr="facebook";
        Assert.assertFalse(actualTitle.contains(arananStr));
    }


    @Test

    public void test3() throws InterruptedException {
     //   sol ust kosede amazon logosunun gorundugunu test et
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }
    @Test
    public void test4(){
        //url'nin facebook.com oldugunu test edin
        String expectedUrl="www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    //assertTrue
    //beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
    // Parametre olarak iki değer alır.
    // İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
    //assertFalse
    //beklenen bir sonucun false olması durumunda kullanılır.
    // İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
    // assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.

}
