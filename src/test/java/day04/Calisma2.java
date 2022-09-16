package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Calisma2 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //robotsepeti.com'a gidiniz
        driver.get("https://robotsepeti.com");
        //tum kategoriler butonuna tiklayiniz
        WebElement tumKategoriler = driver.findElement(By.xpath("//div[@class='col']"));
        tumKategoriler.click();
        //Drone secenegine tiklayiniz
        WebElement droneButonu = driver.findElement(By.linkText("Drone"));
        droneButonu.click();
        //2. resmin tagname'inin 'img' oldugunu dogrulayiniz
        WebElement ikinciResim = driver.findElement(By.xpath("(//img[@class='stImage'])[2]"));

        Thread.sleep(1000);

        String actualTagName = ikinciResim.getTagName();
        System.out.println(actualTagName);
        String expectedTagName = "img";
        if (actualTagName.equals(expectedTagName)) {
            System.out.println("Tagname testi passed");
        } else System.out.println("Tagname testi failed");
        //Icinde bulundugu sayfanin baslik ve url'sini yazdirin
        String sayfaBaslik = driver.getTitle();
        String sayfaUrl = driver.getCurrentUrl();
        System.out.println(sayfaBaslik);
        System.out.println(sayfaUrl);

        //Sayfayi kapatin
        driver.close();

    }
}