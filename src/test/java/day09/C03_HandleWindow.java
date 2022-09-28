package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_HandleWindow {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() {
        driver.quit();

    }
    @Test
    public void test() {
     //  Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //  Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle= driver.getWindowHandle();
     //  Sayfa title’nin “Amazon” icerdigini test edin
        String amazonTitle= driver.getTitle();
        String str="Amazon";
        Assert.assertTrue(amazonTitle.contains(str));
     //  Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
     //  Sayfa title’nin “TECHPROEDUCATION” icermedigini test edin
        String title=driver.getTitle();
        System.out.println(title);
        String str1="TECHPROEDUCATION";
        Assert.assertFalse(title.contains(str1));
        String techWindowHAndle=driver.getWindowHandle();

     //  Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");
     //  Sayfa title’nin “Walmart” icerdigini test edin
        String wlmartTitle=driver.getTitle();
        String str2="Walmart";
        Assert.assertTrue(wlmartTitle.contains(str2));
     //  Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);



    }
}
