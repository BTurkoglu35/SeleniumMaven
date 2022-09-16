package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2 {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method1() {
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        // 2. Username kutusuna “standard_user” yazdirin
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password=driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidiniz
        WebElement ilkUrun=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String ilkUrunIsmi  =ilkUrun.getText();
        System.out.println("ilk urunun ismi : "+ilkUrunIsmi);
        ilkUrun.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrun=driver.findElement(By.id("item_4_title_link"));
        if(sepettekiUrun.isDisplayed()){
            System.out.println("secilen urunun gorunurlugu testi passed");
        }else System.out.println("secilen urunun gorunurlugu testi failed");
    }

    @After
    public void tearDown(){
        //9.Sayfayi kapatin
        driver.close();
    }






















}
