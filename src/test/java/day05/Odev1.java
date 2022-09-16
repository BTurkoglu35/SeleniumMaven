package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev1 {
    /*





6. Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina “2020-09-10” yazdirin
9. Pay buttonuna tiklayin
10. “The payment was successfully submitted.” mesajinin ciktigini control edin
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1(){
        //  1. https://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        // 2. Signin buttonuna tiklayin
        driver.findElement(By.className("icon-signin")).click();
        //3. Login alanine “username” yazdirin
        WebElement login=driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");
        //4. Password alanine “password” yazdirin
        WebElement password=driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");
       //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@name='submit']")).click();








    }














}
