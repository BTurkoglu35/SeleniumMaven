package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void name() {
   //    1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
   //    2. “create new account” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();
   //    3. “firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker();
        String email = faker.internet().emailAddress();
        WebElement firstName = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
 /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerde defalarca kendi üreteceğimiz veriler yerine
        bizim için rondom veriler üretir ve işimizi kolaylaştırır
        Faker classını kullanmak için mvnrepository.com adresinden java-faker kütüphanesini aratır ve ençok kullanılanı
        pom.xml dosyamıza ekleriz. Ve faker class'ından bir obje oluşturup;
        email için faker.internet() methodunu kullanarak emailAddress() methodunu seçeriz.
        password içinde aynı internet methodunu kullanırız.
        İsim ve soyisimler için faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */
        actions.click(firstName).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys().sendKeys(Keys.TAB).sendKeys("12").sendKeys(Keys.TAB).sendKeys("1980").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();




    }
}
