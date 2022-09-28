package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HandleWindows {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
       // driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
   //  Sayfadaki textin “Opening a new window” gorunur olduğunu doğrulayın.
        WebElement text=driver.findElement(By.xpath("//h3"));
       Assert.assertTrue(text.isDisplayed());

   //  Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(title, expectedTitle);
   //  Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        Thread.sleep(2000);
        List<String>windowList=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
   //  Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals(driver.getTitle(),"New Window");
   //  Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yazi=driver.findElement(By.xpath("//h3[text()='New Window']"));
        String str="New Window";
        Assert.assertEquals(yazi.getText(),str);

   //  Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }


}
