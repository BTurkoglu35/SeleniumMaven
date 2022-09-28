package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C03_SenkranizasyonWait extends TestBaseBeforeAfter {
    @Test
    public void implicitWait () {

// 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
// 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
// 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
// 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
// 7. It's back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }

    /*
                imlicitlyWait kullandığımız bu method'da sayfadaki bütün webelementler için
                max belirttiğimiz süre altında bütün web elementler için bekler
                  */
    @Test
    public void explicitWait () {
        //utilities'teki implicitWait satirini yoruma alarak calistiralim.

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // 5. "It's gone!" mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsGoneWE.isDisplayed());
           /*
        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmaz. Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız
         */
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        // 7. It's back mesajinin gorundugunu test edin
        WebElement itsBack=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(itsBack.isDisplayed());
    }
}
