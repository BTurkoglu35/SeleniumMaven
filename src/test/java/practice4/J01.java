package practice4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J01 extends TestBaseBeforeAfter {






    @Test
    public void test() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe=driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        WebElement secondEmoji= driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]"));
        secondEmoji.click();
        // tüm hayvan emojilerine tıklayın
        List<WebElement> tumHayvanEmojileri=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']//img"));
        tumHayvanEmojileri.forEach(t->t.click());
        // formu doldurun (dilediğinizi yazabilirsiniz)
      driver.switchTo().defaultContent();
   //  WebElement text = driver.findElement(By.xpath("(//*[@class='mdl-textfield__input'])[1]"));
   //  text.sendKeys("fdgg");
   //  actions.sendKeys(Keys.TAB).sendKeys("vcvdsv").sendKeys(Keys.TAB).sendKeys("cdnnj").sendKeys(Keys.TAB).sendKeys("csdmkvmk").sendKeys(Keys.TAB).sendKeys("scdskk").
   //  sendKeys(Keys.TAB).sendKeys("sadjnk").sendKeys(Keys.TAB).sendKeys("mckmdkmk").sendKeys(Keys.TAB).sendKeys("mckmdkmkx").sendKeys(Keys.TAB).sendKeys("sx m").
   //  sendKeys(Keys.TAB).sendKeys("sdkj").sendKeys(Keys.TAB).sendKeys("sdwfwwv").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
   //   //2.yol
    List<WebElement> boxes=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

    //bu listi kullanarak webelemnti kolayca boxes listinde bulunan webelemntlerimize gonderebiliriz.
    List<String> text1=new ArrayList<>(Arrays.asList("bu","listi","kullanarak","her","bir","webelemnti","kolayca","boxes","listine","atabiliriz","."));
    for (int i = 0; i <boxes.size() ; i++) {
        boxes.get(i).sendKeys(text1.get(i));

     }
        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();

    }
}
