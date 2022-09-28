package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel extends TestBaseBeforeAfter {
    @Test
    public void test() throws IOException {
        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //FileInputStream objesi olusturup parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //Workbook objesi olusturalim,parameter olarak fileinput stream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        //sayfa2'ye gidip satir sayisinin 6, kullanilan satir sayiisnin 3 oldugunu test edin
       int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);
      int expectedLastRow=191;
        Assert.assertTrue(expectedLastRow==(sonSatir+1));


      int kullanilanSatir=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
      //Excel tablosunda kullllanilan satir sayisi bu method ile alinir.
        System.out.println(kullanilanSatir);
        int expectedKullanilanSatir=191;
        Assert.assertTrue(expectedKullanilanSatir==kullanilanSatir);
    }
}
