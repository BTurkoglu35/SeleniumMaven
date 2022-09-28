package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev1 extends TestBaseBeforeAfter
{

    @Test
    public void name() {

    //    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //    2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverBox= driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverBox).perform();

    //    Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
    //    Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
    //    Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
    //    “Click and hold" kutusuna basili tutun
        WebElement clickAndHold= driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold().perform();
    //    7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
    //    8- “Double click me" butonunu cift tiklayin
         WebElement doubleClick= driver.findElement(By.xpath("//*[@id='double-click']"));
         actions.doubleClick().perform();
    }
}
