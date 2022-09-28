package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    //belirtilen satir no ve sutunda degerlerini parametre olarak alip o cell'deki
    //datayi consola yazdiralim. Sonucun  konsolda yazilanla ayni oldugunu dogrulayin


    @Test
    public void test() throws IOException {
        int satir=12;
        int sutun=2;

        String  dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook wb= WorkbookFactory.create(fis);

        String actualData=wb.getSheet("Sayfa1").
                getRow(satir-1).
                getCell(sutun-1).
                toString();
//index sifirdan basladigi icin bizden istenen satia ulasabilmek icin bir eksigini aliriz
        System.out.println(actualData);

        String  konsoldaYazan="Baku";
        Assert.assertEquals(konsoldaYazan, actualData);
    }
}
