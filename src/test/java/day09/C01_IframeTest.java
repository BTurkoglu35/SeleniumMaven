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

public class C01_IframeTest {
      /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //   ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
      WebElement yazi=  driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(yazi.isDisplayed());
        System.out.println(yazi.getText());
        //  ○ Text Box’a “Merhaba Dunya!” yazin.
         WebElement textBox=driver.findElement(By.id("mce_0_ifr"));
         driver.switchTo().frame(textBox);
        Thread.sleep(2000);
        WebElement textBoxFrame=driver.findElement(By.xpath("//p"));
       textBoxFrame.clear();
       textBoxFrame.sendKeys("Merhaba Dunya!");

        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();//iframe'den cikip  ana sayfaya gecmek icin bu method kullanilir.
       WebElement elemental=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
       Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());



    }





}
