package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdreivr.chrome.driver","src/min/java/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://amazon.com");

        driver.getCurrentUrl();

        driver.manage().window().maximize();

        driver.getTitle();

        driver.getPageSource();

        driver.getWindowHandle();

        driver.navigate();

        driver.quit();

        driver.close();

        driver.wait();




    }
}
