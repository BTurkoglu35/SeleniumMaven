package day08;

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

public class C04_Iframe {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test() {
        //https://html.com/tags/iframe/
        driver.get("https://html.com/tags/iframe/ ");
       //youtube videosunu calistirin
              /*
      Bir web sitesinde bir video(youtube vs) varsa <iframe> tag'i içerisindeyse bu video'yu direkt locate edip çalıştırmak dinamik olmaz.
      Çünkü link değişebilir ve locate'imiz çalışmaz.
      Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tuşunu locate edip çalıştırabiliriz.
      */
    //   List<WebElement> iframeList=driver.findElements(By.xpath("//iframe"));//new ArrayList<>(driver.findElements(By.xpath("//iframe")));
    //  driver.switchTo().frame(iframeList.get(0));
    //  driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
    }
}