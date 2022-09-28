package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {
    /*
    Bir class olusturun: Alerts
●
//
●
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void acceptAlert(){
//     ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//      “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement result=driver.findElement(By.xpath("//*[@id='result']"));
        String actualResult=result.getText();
        String expectedResult="You successfully clicked an alert";
         Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void  dismissAlert()  {
         //○ 2. butona tıklayın,
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //alert uzerindeki mesji yazdirin
        System.out.println(driver.switchTo().alert().getText());
         //uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("//*[@id='result']"));
        String actualResult=result.getText();
        String satir="successfuly";
        Assert.assertFalse(actualResult.contains(satir));

    }
    @Test
    public void sendKeysAlert(){
        //○ 3. butona tıklayın,
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //alert uzerindek mesaji yazdirin
        System.out.println(driver.switchTo().alert().getText());
       //uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajınin isminizi  icerdigini doğrulayın
        driver.switchTo().alert().sendKeys("Ayse");
        driver.switchTo().alert().accept();
        String actualResult=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedResult="Ayse";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

}