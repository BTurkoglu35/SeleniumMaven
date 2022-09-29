package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RadioButtonTest {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void method1() throws InterruptedException {
        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //Cookies’i kabul edin
        //Create an Account” button’una basin
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
        //butonlari locate ediniz
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Busgd");
        WebElement surname = driver.findElement(By.name("lastname"));
        surname.sendKeys("sasdfv");
        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("sdfdfd@dsfd");
        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("sdfddsdf");
        WebElement day = driver.findElement(By.name("birthday_day"));
        Select options = new Select(day);
        options.selectByIndex(2);
        WebElement month = driver.findElement(By.name("birthday_month"));
        Select options2 = new Select(month);
        options2.selectByIndex(1);
        WebElement year = driver.findElement(By.name("birthday_year"));
        Select options3 = new Select(year);
        options3.selectByValue("2020");
        Thread.sleep(3000);
        //- “radio buttons” elementlerini locate edin
        WebElement male = driver.findElement(By.xpath("//*[text()='Male']"));
        WebElement custom = driver.findElement(By.xpath("//*[text()='Custom']"));


        //Secili degilse cinsiyet butonundan size uygun olani secin
        WebElement femaleGender = driver.findElement(By.xpath("//*[text()='Female']"));
        if (!femaleGender.isSelected()) {
            femaleGender.click();
            System.out.println("female selected");
        } else System.out.println("Female zaten secili");
        Thread.sleep(2000);


    }

    @After
    public void tearDown() {
        driver.close();
    }


}

