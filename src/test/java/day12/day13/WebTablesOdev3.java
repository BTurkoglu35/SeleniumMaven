package day12.day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class WebTablesOdev3 extends TestBaseBeforeAfter {
//  Bir Class olusturun D19_WebtablesHomework
//   1. “https://demoqa.com/webtables” sayfasina gidin
//   2. Headers da bulunan department isimlerini yazdirin
//   3. sutunun basligini yazdirin
//   4. Tablodaki tum datalari yazdirin
//   5. Tabloda kac cell (data) oldugunu yazdirin
//   6. Tablodaki satir sayisini yazdirin
//   7. Tablodaki sutun sayisini yazdirin
//   8. Tablodaki 3.kolonu yazdirin
//   9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
//   10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
//  girdigimde bana datayi yazdirs

    @Test
    public void test() {
        //   1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
//   2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> departmentList = new ArrayList<>(driver.findElements(By.xpath("//div[@role='gridcell'][6]")));
        departmentList.forEach(t-> System.out.println("Department : "+t.getText()));
//   3. sutunun basligini yazdirin
   //     WebElement baslik=driver.findElement(By.xpath("(//div[@role='row'])[1]"));
   //     System.out.println(baslik.getText());
//   4. Tablodaki tum datalari yazdirin
        WebElement tumTablo=driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
        System.out.println(tumTablo.getText());

//   5. Tabloda kac cell (data) oldugunu yazdirin
     List<WebElement> data=new ArrayList<>(driver.findElements(By.xpath("//div[@class='rt-td']")));
        System.out.println(data.size());
//   6. Tablodaki satir sayisini yazdirin
        List<WebElement>satirSayisini = driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println(satirSayisini.size());
//   7. Tablodaki sutun sayisini yazdirin
        List<WebElement>sutunSayisini = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println(sutunSayisini.size());
//   8. Tablodaki 3.kolonu yazdirin
        List<WebElement>ucuncuKolonElemanlari = driver.findElements(By.xpath("//div[@role='gridcell'][3]"));
        System.out.println(ucuncuKolonElemanlari.size());
//   9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
//   10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
//  girdigimde bana datayi yazdirs


    }
}
