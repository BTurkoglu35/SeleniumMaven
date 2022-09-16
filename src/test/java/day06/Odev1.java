package day06;

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

public class Odev1 {
    // 1.Bir Class olusturalimYanlisEmailTesti





    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        // 2.http://automationpractice.com/index.php sayfasinagidelim
        driver.get("http://automationpractice.com/index.php");
        // 3.Sign in butonunabasalim
        driver.findElement(By.xpath("//*[@class='login']")).click();
        // 4.Email kutusuna @isareti olmayan bir mail yazipenter'a bastigimizda create_account_error uyarisi ciktigini testedelim
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("asdfookko");
        driver.findElement(By.xpath("//*[@name='SubmitCreate']")).click();
        WebElement actualHataMesaji=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(actualHataMesaji.isDisplayed());
    }

    @After
    public void tearDown()  {
        driver.close();
    }
}
