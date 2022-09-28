package day12.day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    int satir = 3;
    int sutun = 4;

    @Test
    public void test1() {
        //Bir onceki claasdaki adrese gidelim
        //login() methodunu ki=ullanarak sayfya giris yapalim.
        login();
        //input olarak verilerm=n satir sayisi ve sutun sayisina sahip cell'deki texti yazdiralim
        WebElement cell = driver.findElement(By.xpath("//tbody/tr[" + satir + "]/td[" + sutun + "]"));
        System.out.println("satir ve sutundaki text : " + cell.getText());

        //price basligindaki tum numaralari yazdiralim.
        List<WebElement> price = driver.findElements(By.xpath("//tbody/tr//td[6]"));
        price.forEach(t -> System.out.println(t.getText()));
    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).
                sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }
}
