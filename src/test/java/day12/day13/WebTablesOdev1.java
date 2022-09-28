package day12.day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class WebTablesOdev1 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //         ● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        //         ○ Username : manager ○ Password : Manager2!
        driver.get("https://www.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //        ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> body= driver.findElements(By.xpath("//tbody/tr[1]/td"));
        System.out.println(body.size());

        //        ○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
       List<WebElement> baslikveBody=driver.findElements(By.xpath("//*[@id='datatable_ajax']"));
   //   baslikveBody.forEach(t-> System.out.println(t.getText()) );

        //        table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement>bodySatir= driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Body'de bulunan satir sayisi : "+bodySatir.size());
     //         ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        bodySatir.forEach(t-> System.out.println(t.getText()));

        //         ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        WebElement dorduncuSatir= driver.findElement(By.xpath("//tbody/tr[4]"));
        System.out.println("4. satir elementleri : "+dorduncuSatir.getText());
        //      ○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> cell=driver.findElements(By.xpath("//tbody/tr/td"));
        System.out.println("hucre sayisi : "+cell.size());

        //         ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
    //    cell.forEach(t-> System.out.println(t.getText()));

        //      ○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> columnSayisi= driver.findElements(By.xpath("//tbody/tr[1]/td"));
        System.out.println(columnSayisi.size());
        //         ○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
     List<WebElement> column=driver.findElements(By.xpath("//tbody/tr/td"));
        column.forEach(t-> System.out.println(t.getText()));

        //         ○ 5.column daki elementleri konsolda yazdırın.
       List<WebElement> besinciColumn=driver.findElements(By.xpath("//tbody/tr/td[5]"));
       besinciColumn.forEach(t-> System.out.println(t.getText()));

    }
}
