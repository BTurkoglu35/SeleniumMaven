package day12.day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;


public class C02_WebTables extends TestBaseBeforeAfter {
//   ● Bir class oluşturun : C02_WebTables
//    ● login( ) metodun oluşturun ve oturum açın

//           // ○ Username : manager
//    ○ Password : Manager1!









    @Test
    public void test() {
        //   ● `https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
       login();
       //table( ) metodu oluşturun
        table();
        // ● printRows( ) metodu oluşturun //tr
        printRows();
    }

    private void printRows() {
        //   ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satir=driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("satir sayisi : "+satir.size());
        //           ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        satir.forEach(t-> System.out.println(t.getText()));
        //           ○ 4.satirdaki(row) elementleri konsolda yazdırın
        System.out.println("tablodaki 4. satir : "+driver.findElement(By.xpath("//tbody/tr[4]")).getText());
    }

    private void table() {
        /*
        tabloda <table> tag'i altinda tablonun basligini gosteren <head> tag'i bulunur.
        Eger baslikta satir(row) varsa <thead> tag'i altinda <tr>(satir-row) tagi vardir.
        Ve baslliktaki sutunlara yani hucrelere de <th> tagi ile ulasilir.
        Basligin tablodaki verilere <tbody> tag'i ile altindaki satirlara (row),tr. tag'i ile
        situnlara yani hucrelere <td> tag'i ile ulasiriz.
         */
        //    ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead/tr/th"));
        System.out.println("tablodaki sutun sayisi "+sutunSayisi.size());
        //   ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement baslik=driver.findElement(By.xpath("//thead/tr"));
        System.out.println("Basliklar " +baslik.getText());

        WebElement body=driver.findElement(By.xpath("//tbody"));
        System.out.println("tum body :"+body.getText());

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
      WebElement userName= driver.findElement(By.xpath("//*[@id='UserName']"));
      actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).
              sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
