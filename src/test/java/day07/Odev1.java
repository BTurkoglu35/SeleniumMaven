package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev1 {

    WebDriver driver;
    Select select;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test()  {
   //   1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get(" http://zero.webappsecurity.com/ ");
   //   2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
   //   3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
   //   4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
   //   5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();
   //   6. Pay Bills sayfasina gidin
        //ilk online banking'e tikliyoruz
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        //pay bills'e gidiyoruz
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

   //   7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
   //   8. “Currency” drop down menusunden Eurozone’u secin
        WebElement curreny= driver.findElement(By.xpath("//*[@id='pc_currency']"));
        select=new Select(curreny);
        select.selectByValue("EUR");
   //   9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("12");
   //   10. “US Dollars” in secilmedigini test edin
        WebElement dolarButonu=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(dolarButonu.isSelected());
   //   11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
   //   12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@value='Calculate Costs']")).click();
        driver.findElement(By.id("purchase_cash")).click();

   //   13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement actualSonucYazisi = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        String expectedSonucYazisi="Foreign currency cash was successfully purchased.";
        Assert.assertEquals(actualSonucYazisi.getText(), expectedSonucYazisi);

    }












}
