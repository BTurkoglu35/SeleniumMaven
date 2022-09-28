package day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class C01_ReadExcel {
    @Test
    public void test1() throws IOException {
        //dosya yolunu bir string degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //FileInputStream objesi olusturup parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //Workbook objesi olusturalim,parameter olarak fileinput stream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);
        //excel tablosundaki tum tabloyu konsola yazdirin
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
         String tablo="";
        for (int i = 0; i <sonSatir ; i++) {
           tablo=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()+","+
                   workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+","+
                   workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+","+
                   workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(tablo);

        }
    }
}
