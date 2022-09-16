package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
       /*
        1) Bir class oluşturun: YoutubeAssertions
        2) https://www.youtube.com adresine gidin
        3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        ○ titleTest
        => Sayfa başlığının “YouTube” oldugunu test edin
        ○ imageTest
        => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        */
   static WebDriver driver;

   @BeforeClass
    public static  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.youtube.com Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get( "https://www.youtube.com");
    }

    @Test
    public void test1(){
    //    ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualBaslik=driver.getTitle();
        String expectedBaslik="YouTube";
        Assert.assertEquals("baslik uyusmuyor",actualBaslik, expectedBaslik);
    }

    @Test
    public void test2(){
       //○ imageTest=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo=driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test3(){
      //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox =driver.findElement(By.xpath("//*[@name='search_query']"));
        Assert.assertTrue(searchBox.isEnabled());

    }
    @Test
    public void test4() {
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualBaslik = driver.getTitle();
        String expectedBaslik = "youtube";
        Assert.assertNotEquals(actualBaslik, expectedBaslik);
    }

    @AfterClass
    public static void tearDown() {
       driver.close();
    }



}
