package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
   /*




*/
    WebDriver driver;
    Select select;
    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/dropdown");
    }
    @After
    public void tearDown()  {
        driver.close();

    }
    @Test
    public void test1()  {
        // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
      WebElement optionBox= driver.findElement(By.xpath("//*[@id='dropdown']"));
      optionBox.click();
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select =new Select(optionBox);
       select.selectByIndex(1);
       System.out.println(driver.findElement(By.xpath("//*[text()='Option 1']")).getText());
       // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

       // Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
       select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //    Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumOpsiyonlar=driver.findElements(By.xpath("//*[@id='dropdown']"));
        for (WebElement op :tumOpsiyonlar) {
            System.out.print(op.getText());
        }
        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int dropdownBoyutu=tumOpsiyonlar.size();
        int expectedSayi=4;
        if(dropdownBoyutu==expectedSayi){
            System.out.println("true");
        }else System.out.println("false");
        Assert.assertNotEquals(dropdownBoyutu,expectedSayi);
    }

}
