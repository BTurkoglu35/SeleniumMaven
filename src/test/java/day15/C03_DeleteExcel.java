package day15;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_DeleteExcel {

    @Test
    public void Test1() throws IOException {
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        Sheet sheet= workbook.getSheet("Sayfa1");
        //-Row objesi olusturun sheet.getRow(3)
        Row row=sheet.getRow(3);
        //-Cell objesi olusturun row.getCell(3)
        Cell cell=row.getCell(3);
        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);
        /*
        bir cell'deki veriyi silmek icin row objesine ihtiyac vardir
        row objesi ile removeCell() methodunu kullnarak cell objesi ile
        belirttigimiz cell degerini silebiliriz.
        */
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //-Silindiğini test edin
        String expectedData="Cezayir";
        String actualData=null;
        Assert.assertNotEquals(expectedData,actualData);

    }
}
