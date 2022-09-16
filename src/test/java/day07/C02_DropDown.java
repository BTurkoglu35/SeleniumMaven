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

public class C02_DropDown {
    WebDriver driver;
    Select select;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test1()  {
     //   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45  oldugunu testedin
        WebElement kategori= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(kategori);

        /*
        Drop down menuye ulasmak icin select classindan bir obje olustururuz
       ve locate ettigimiz webelementini select classina tanimlariz ve getoption methodunu kullanarak
       dropdown'u bir liste atarak  drop down menunun butun elemanlarinin sayisina ulasabiliriz.
         */

        List<WebElement> kategoriList=select.getOptions();
        System.out.println(kategoriList.size());
        int expectedSayi=45;
        int actualKategori=kategoriList.size();
        Assert.assertNotEquals(actualKategori, expectedSayi);


    }
    @Test
    public void test2()  {
        //   1.Kategori menusunden Books seceneginisecin
        WebElement kategori= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(kategori);
        select.selectByVisibleText("Books");
     //   2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
     //   3.Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());
     //   4.Sonucun Java kelimesini icerdigini testedin
        String arananKelime="Java";
        Assert.assertTrue(sonucYazisi.getText().contains(arananKelime));
    }
}
