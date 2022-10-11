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

public class Calisma1 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void methos1() throws InterruptedException {
        //  2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarılı bir şekilde görünür olduğunu doğrulayın(Ana sayfanın başarıyla görüldüğünü doğrulayın)
        WebElement anasayfa = driver.findElement(By.className("col-sm-8"));
        if (anasayfa.isDisplayed()) {
            System.out.println("Anasayfa testi passed");
        } else System.out.println("Anasayfa testi failed");
        //  4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //  5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        WebElement yeniKullanici = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (yeniKullanici.isDisplayed()) {
            System.out.println("Yeni kullanici test passed");
        } else System.out.println("Yeni kullanici test failed");
        //  6. Adı ve e-posta adresini girin
        WebElement name = driver.findElement(By.xpath("//*[@type='text']"));
        name.sendKeys("Bt");
        Thread.sleep(3000);
        WebElement eposta = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        eposta.sendKeys("yat@gmail.com");
        Thread.sleep(3000);

        //  7. 'Kaydol' düğmesini tıklayın
        WebElement signup = driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
        signup.click();
        //  8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        Thread.sleep(3000);
        WebElement hesapBilgileri = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (hesapBilgileri.isDisplayed()) {
            System.out.println("Hesap bilgileri gorunurlugu passed");
        } else System.out.println("Hesap bilgileri gorunurlugu failed ");
        //  9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        driver.findElement(By.xpath("//*[@for='id_gender2']")).click();
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.sendKeys("1245");
        //gun secme
        WebElement days = driver.findElement(By.xpath("//*[@id='days']"));
        Select options = new Select(days);
        options.selectByIndex(3);
        //   //ay secme
        WebElement months = driver.findElement(By.xpath("//*[@id='months']"));
        Select options1 = new Select(months);
        options1.selectByIndex(5);
        //   //yil secme
        WebElement years = driver.findElement(By.xpath("//*[@id='years']"));
        Select options2 = new Select(years);
        options2.selectByValue("2020");
        //  10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Sign up for our newsletter!']")).click();
        //  11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Receive special offers from our partners!']")).click();
        //  12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        WebElement firstName = driver.findElement(By.xpath("//*[@id='first_name']"));
        firstName.sendKeys("Ayse");
        WebElement lastName = driver.findElement(By.xpath("//*[@id='last_name']"));
        lastName.sendKeys("Aslan");
        WebElement sirket = driver.findElement(By.xpath("//*[@id='company']"));
        sirket.sendKeys("Farmasi");
        WebElement Adres = driver.findElement(By.xpath("//*[@id='address1']"));
        Adres.sendKeys("Aliaga mahallesi Armut sokak No:12");
        WebElement Adres2 = driver.findElement(By.xpath("//*[@id='address2']"));
        Adres2.sendKeys("Mehmetaga mahallesi Elma sokak No:12");
        WebElement country = driver.findElement(By.xpath("//*[@name='country']"));
        Select countrySec = new Select(country);
        countrySec.selectByValue("Canada");
        WebElement eyalet = driver.findElement(By.xpath("//*[@id='state']"));
        eyalet.sendKeys("Nehir");
        WebElement sehir = driver.findElement(By.xpath("//*[@id='city']"));
        sehir.sendKeys("Balikesir");
        WebElement postaKodu = driver.findElement(By.xpath("//*[@id='zipcode']"));
        postaKodu.sendKeys("12");
        WebElement cepNumarasi = driver.findElement(By.xpath("//*[@id='mobile_number']"));
        cepNumarasi.sendKeys("1215546548");

        //  13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).submit();
        //  14. 'HESAP OLUŞTURULDU!' görünür
        Thread.sleep(3000);
        WebElement hesapOlusturuldu = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (hesapOlusturuldu.isDisplayed()) {
            System.out.println("Hesap olusturuldu yazisi gorunurlugu testi passed");
        } else System.out.println("Hesap olusturuldu yazisi gorunurlugu testi failed");
        //  15. 'Devam' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        //  16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        WebElement kullaniciAdiIleOturumAcildi = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        if (kullaniciAdiIleOturumAcildi.isDisplayed()) {
            System.out.println("Kullanıcı adı olarak oturum açıldı testi passed");
        } else System.out.println("Kullanıcı adı olarak oturum açıldı testi failed");
        //  17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();
        //  18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın
        WebElement hesabiSil = driver.findElement(By.xpath(("//h1[text()='Delete Account']")));
        if (hesabiSil.isDisplayed()) {
            System.out.println("Hesabi sil yazisi testi passed");
        } else System.out.println("Hesabi sil yazisi testi failed");

    }

    @After
    public void tearDown() {
        driver.close();
    }

}
