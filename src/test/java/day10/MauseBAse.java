package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class MauseBAse extends TestBaseBeforeAfter {
    @Test
    public void test(){
     //   Yeni bir class olusturalim: MouseActions2
     //   https://demoqa.com/droppable adresine gidelim
        driver.get(" https://demoqa.com/droppable");
     //  “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragme = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragme,dropHere).perform();
     //   “Drop here” yazisi yerine “Dropped!” oldugunu test edin
     //   WebElement result = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String str="Dropped!";
        Assert.assertEquals(str,dropHere.getText());
    }
}
