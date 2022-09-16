package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.time.Duration;

public class Odev3 {
    /*
    1-C01_TekrarTesti isimli bir class olusturun






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
    public void method1() {
        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin

        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualBAslik=driver.getTitle();
        String arananKelime="Google";
        if (actualBAslik.contains(arananKelime)) {
            System.out.println("Baslik testi passed");
        }else System.out.println("Baslik testi failed");
        //5 Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@type='text']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        System.out.println(Integer.MAX_VALUE);
        //6 Bulunan sonuc sayisini yazdirin
        WebElement sonucYazsisi=driver.findElement(By.xpath("//*[@id='result-stats']"));
        String [] sonucYazisiArr=sonucYazsisi.getText().split(" ");
        String sonucSayisi=sonucYazisiArr[1];
        System.out.println("souc sayisi : "+sonucSayisi);
        sonucSayisi=sonucSayisi.replaceAll(",","");

        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int actualSonucSayisi=Integer.parseInt(sonucSayisi);
        int expectedSonucSayisi=10000000;

        if(actualSonucSayisi>expectedSonucSayisi){
            System.out.println("sonuc sayisinin 10 milyon’dan fazla oldugu  testi passed");
        }else System.out.println("sonuc sayisinin 10 milyon’dan fazla oldugu  testi failed");

    }

    @After
    public  void  tearDown() {
        //8 Sayfayi kapatin
        driver.close();
    }




}
