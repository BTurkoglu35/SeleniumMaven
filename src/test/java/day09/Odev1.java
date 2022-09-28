package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Odev1 {

    WebDriver driver;

    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void test() throws InterruptedException {

     //  1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
     //  2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        System.out.println(iframeList.size());
     //  3) iframe'deki (Youtube) play butonuna tıklayınız.

        driver.switchTo().frame(iframeList.get(7));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
        Thread.sleep(2000);

     //  4) iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
     //  5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tiklayiniz
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='a077aa5e']")));
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        Thread.sleep(2000);
    }









}
