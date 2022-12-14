package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon gidelim
        driver.get("https://www.amazon.com");
        ///nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //Arama sonuc yazisinin resmini alalim
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaArmaSonucu=aramaSonucu.getScreenshotAs(OutputType.FILE);
        //sadece web elementin resmini alacaksak TakesScreenshot classini kullanmaniza gerek yok
        //Locate ettigimiz webelemnti direk gecici bir file'a atip fileUtils ile kopyalayip yolunu(path) belirtiriz.
      FileUtils.copyFile(nutellaArmaSonucu,new File("target/ekranGoruntusuWE/WebESS"+tarih+".jpeg"));

    }
}
