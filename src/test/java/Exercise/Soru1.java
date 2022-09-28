package Exercise;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class Soru1 extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın

        //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın

        //5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        //6. Adı ve e-posta adresini girin
        //7. 'Kaydol' düğmesini tıklayın
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin görünür olduğunu doğrulayın
        //9. Doldurma ayrıntıları: Unvan, Ad, E-posta, Şifre, Doğum tarihi
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //12. Doldurma ayrıntıları: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        //13. 'Hesap Oluştur düğmesini' tıklayın
        //14. 'HESAP OLUŞTURULDU!' görünür
        //15. 'Devam' düğmesini tıklayın
        //16. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
        //17. 'Hesabı Sil' düğmesini tıklayın
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam' düğmesini tıklayın

    }
}
