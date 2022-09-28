package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {
    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\ASUS\IdeaProjects\com.Batch81Maven
        //suanki icinde bulundugum yolu gosterir

        System.out.println(System.getProperty("user.home"));//C:\Users\ASUS
        //gecerli kulllanicinin ana dilini verir.

        String farkliBolum=System.getProperty("user.home");
       String ortakBolum="\\Desktop\\text.txt.txt";
/*
        String masaustuDosyaYolu=farkliBolum+ortakBolum;
        System.out.println(masaustuDosyaYolu);
        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

*/
     String dosyaYolu="C:\\Users\\ASUS\\Desktop\\text.txt.txt";
     System.out.println(Files.exists(Paths.get(dosyaYolu)));
     Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

     /*
     Bir web sitesinden indrirdigimiz yada windows icinde olusturdugumuz dosyanin indigini yada orada oldugunu
     test edebilmem icin o dosyanin uzerine shift tusuna basili olarak sag click yapip dosyanin yolunu kopyalayip
     bir string degiskene atariz ve dosyayi dogrulamak icin
     Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullaniriz.
      */




    }
}
