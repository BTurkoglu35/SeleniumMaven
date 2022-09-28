package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.awt.image.Kernel;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void name() {
        //Automationexercises.com sitesine gidelim
        driver.get("https://www.automationexercise.com");
        //Product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        //ilk ürüne tıklayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
    }
}

