package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import javax.management.relation.Relation;
import java.util.List;



public class Odev3 extends TestBaseBeforeAfter {
    /*

     */

    @Test
    public void test1() {
 //       -  amazon gidin
        driver.get("https://amazon.com");
 //       Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement>dropDownMenu=driver.findElements(By.xpath("//option"));
        for (WebElement each : dropDownMenu) {
            System.out.println(each.getText());
        }
        System.out.println(dropDownMenu.size());
 //       dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertFalse(dropDownMenu.size()==40);




    }

    @Test
    public void test2() {
        driver.get("https://amazon.com");
   //    dropdown menuden elektronik bölümü seçin
       WebElement dropDown=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(dropDown);
         select.selectByVisibleText("Electronics");
         //    arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisi1=sonucYazisi.getText();
        String[] arr=sonucYazisi1.split(" ");
        System.out.println(arr[2]);
   //    sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String arananKelime="iphone";
        Assert.assertTrue(sonucYazisi1.contains(arananKelime));
   //    ikinci ürüne relative locater kullanarak tıklayin
        WebElement alttakiUrun=driver.findElement(By.xpath("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-8']"));
        WebElement sagdakiUrun=driver.findElement(By.xpath("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-3']"));
        driver.findElement(RelativeLocator.with(By.tagName("div")).toLeftOf(sagdakiUrun).above(alttakiUrun)).click();
        //    ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
   //    String title =driver.getTitle();
   //    WebElement urunFiyati=driver.findElement(By.xpath("//span[@id='price_inside_buybox']"));
   //    String urunFiyatii=urunFiyati.getText();
    }

    @Test
    public void test3() {
        driver.get("https://amazon.com");
     //   yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
     //   dropdown’dan bebek bölümüne secin
        WebElement dropDown=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(dropDown);
        select.selectByValue("search-alias=baby-products-intl-ship");
     //   bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puseti"+ Keys.ENTER);
        WebElement result=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String resultText=result.getText();
        String[] resultarr=resultText.split(" ");
        System.out.println("sonuc sayisi : "+resultarr[2]);
     //   sonuç yazsının puset içerdiğini test edin
        String arananKelime="puset";
        Assert.assertTrue(resultText.contains(arananKelime));
     //   5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ustUrun = driver.findElement(By.xpath("(//div[@class='a-section'])[2]"));
        ustUrun.click();
        WebElement altUrun=driver.findElement(By.xpath("(//div[@class='a-section'])[4]"));
 //     WebElement ucuncuurun=driver.findElement(RelativeLocator.with(By.tagName("div")).above(altUrun).below(ustUrun));
 //     ucuncuurun.click();


 //  //   6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
 //     String title = driver.getTitle();
 //     WebElement fiyat=driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']"));
 //     String urunFiyati=fiyat.getText();
 //     System.out.println(title);
 //     System.out.println(urunFiyati);
 //     driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
 //     //    1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
 //     driver.findElement(By.id("nav-cart-count-container")).click();

    }


}
