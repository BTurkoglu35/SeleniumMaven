package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C02_MouseActions extends TestBaseBeforeAfter {
    @Test
    public void name() {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstName = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        actions = new Actions(driver);
        firstName.sendKeys("Bsra");
        actions.sendKeys(Keys.TAB).sendKeys("Turk").sendKeys(Keys.TAB).sendKeys("sdkljf@gmail.com").
                sendKeys(Keys.TAB).sendKeys("sdkljf@gmail.com").
                sendKeys(Keys.TAB).sendKeys("54641").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("12").sendKeys(Keys.TAB).sendKeys("1980").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //4- Kaydol tusuna basali
    //    driver.findElement(By.xpath("//*[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']")).click();
    }
}
