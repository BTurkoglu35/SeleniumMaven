package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);//olusturmus oldugumuz dosyayi sistemde isleme alir.
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);//workbook objesiyle fis objesi ile akisa aldigimiz
                                                     //dosyamizla bir excel dosyasi creat ettik.
        //- WorkbookFactory.create(fileInputStream)
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1");//excel dosyamizda calismak istedigiiz ssayfayi bu sekilde seceriz
        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3);   //sayfa 1 deki 3 satiri sectik
        //- Cell objesi olusturun row.getCell(index)
        Cell  cell=row.getCell(3);//satir secimi yapildiktan sonra hucre secimi bu sekilde yapilir.
        System.out.println(cell);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
       String expectedData="Cezayir";
        String actualData=cell.toString();
        Assert.assertEquals(expectedData, actualData);



    }
}
