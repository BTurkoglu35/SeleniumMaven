package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_MouseBase extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //    Yeni bir class olusturalim: MouseActions1
        //    https://the-internet.herokuapp.com/context_menu sitesine gidelim  3- Cizili alan uzerinde sag click yapalim
        driver.get(" https://the-internet.herokuapp.com/context_menu");
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.moveToElement(kutu).contextClick().perform();
        //    Alert’te cikan yazinin “You selected a context menu” oldugunu
        String alertYazi = driver.switchTo().alert().getText();
        String expectedYazi = "You selected a context menu";
        Assert.assertEquals(alertYazi, expectedYazi);

        //    Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //    Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        //    Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        String expectedYazi1 = "Elemental Selenium";
        Assert.assertEquals(h1.getText(), expectedYazi1);

    }
}
