package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

     @Test
    public void Method1() {
        //1 defa Before calisir
        driver.get("https://www.amazon.com");
        //1 defa after calisir
    }
    @Test
    public void Method2() {
        //1 defa Before calisir
        driver.get("https://www.facebook.com");
        //1 defa after calisir
    }
}