package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DersTekrari1 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasina git
        driver.get("https://amazon.com");
    }

    @Test
    public void test1() {
        //- url'in "amazon" icergini test et
        String actualUrl = driver.getCurrentUrl();
        String arananKelime = "amazon";
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }

    @Test
    public void test2() {
        //  b-title'in facebook icermedigini test edelim
        String actualBaslik = driver.getTitle();
        String str = "facebook";
        Assert.assertFalse(actualBaslik.contains(str));
    }

    @Test
    public void test3() {
        //   sol ust de konum butonunun gorundugunu test et
        WebElement konum = driver.findElement(By.id("glow-ingress-block"));
        Assert.assertTrue(konum.isDisplayed());
    }

    @Test
    public void test4() {
        //url'nin twitter.com olmadigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "twitter.com";
        Assert.assertNotEquals(actualUrl, expectedUrl);
    }

    @Test
    public void test5() {
        //sepete tiklayalim
        //"Your Amazon Cart is empty" yazisinin gotunurlugunu test edelm
        driver.findElement(By.id("nav-cart-count-container")).click();
        WebElement isEmptyYazisi = driver.findElement(By.xpath("//*[@class='a-row sc-your-amazon-cart-is-empty']"));
        Assert.assertTrue(isEmptyYazisi.isDisplayed());
    }

    @Test
    public void test6() throws InterruptedException {
        //arama butonunu locate et
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //arama butonuna ayakkabi yazalim
        aramaKutusu.sendKeys("ayakkabi" + Keys.ENTER);
        //ikinci resimdeki ayakkabiyi locate edelim ve basliginda Shoes kelimesinin gectigini test edelim
        WebElement ikinciResim = driver.findElement(By.xpath("(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[2]"));
        String arananKelime = "Shoes";
        Assert.assertTrue(ikinciResim.getText().contains(arananKelime));
        Thread.sleep(2000);

    }


    @Test
    public void test7() throws InterruptedException {

        //arama butonunu locate et
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        //arama butonuna oyuncaklar yazalim
        aramaKutusu.sendKeys("oyuncak" + Keys.ENTER);
        Thread.sleep(2000);
        //Baby & Toddler Toys filtersini secelim
        driver.findElement(By.xpath("//*[text()='Baby & Toddler Toys']")).click();
        Thread.sleep(2000);
        //10. resimdeki oyuncagi locate edelim
        WebElement onuncuResim = driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        onuncuResim.click();
        //10. resimdeki oyuncagi sepete ekleyelim
        driver.findElement(By.xpath("(//*[@id='add-to-cart-button'])[1]")).click();

        //Urunun sepete eklendigini test edelim
        driver.findElement(By.id("nav-cart-count-container")).click();
        // WebElement isEmptyYazisi=driver.findElement(By.xpath("//*[@class='a-row sc-your-amazon-cart-is-empty']"));
        WebElement sepettekiUrun = driver.findElement(By.xpath("//*[@class='a-truncate-cut']"));
        Assert.assertTrue(sepettekiUrun.isDisplayed());

    }


}

















