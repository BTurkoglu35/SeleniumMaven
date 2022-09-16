package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDownHandle {

    WebDriver driver;
    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //https://www.amazon.com/ adresinegidin.
        driver.get("https://www.amazon.com");
    }

    @After
    public void after() {
      //  driver.close();
    }

    @Test
    public void Method1() {
        //-Test1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45 oldugunu testedin
        List<WebElement> drops = driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());
        for (WebElement w : drops) {
            System.out.println(w.getText());
        }
        int dropDownList=drops.size();
        int expectedSayi=45;
        Assert.assertNotEquals(dropDownList,expectedSayi);

    }
    @Test
    public void test2()  {
     //  1.Kategori menusunden Books seceneginisecin
     WebElement kategori= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
     kategori.sendKeys("Books");
     //  2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
     //  3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
     //  4.Sonucun Java kelimesini icerdigini testedin
        String arananKelime="Java";
        Assert.assertTrue(sonucYazisi.getText().contains(arananKelime));
    }

}
