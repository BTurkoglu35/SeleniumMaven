package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_Upload extends TestBaseBeforeAfter {
    @Test
    public void name() {
        //   https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get(" https://the-internet.herokuapp.com/upload");
        //   chooseFile butonuna basalim
        //   Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
     /*
     Dosya sec butonuna direk click yapamayabiliriz cunku windows'a mudahale izin
     veremyebilir.Bu yuzden dosya sec buyonunu direk locate edip sendKeys methodu
     ile string degiskene atadigimiz dosyayolumuzu gondereriz.
      */
        //   actions.click(chooseFile).perform();
        String dosyaYolu = "C:\\Users\\ASUS\\Downloads\\test.txt";
        chooseFile.sendKeys(dosyaYolu);
        //   Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //    “File Uploaded!” textinin goruntulendigini test edelim.
        driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
