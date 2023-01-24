package day16_ExcelRead_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {
        //WORKBOOK > SHEET > ROW > CELL > YAZ > KAYDET
        String path = "./src/test/java/resources/Capitals.xlsx";// =>  ./ hepsi, tamami demek.

        //DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCEL DOSYASINI AC / WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //SAYFAYI AC / Sheet1
        //Sheet sheet1 = workbook.getSheetAt(0);//index 0 dan baslar. Ilk sayfayi ac.
        Sheet sheet1 = workbook.getSheet("Sheet1");//Sheet1 isimli sayfayi ac.

        //ILK SATIRA GIDELIM / ROW
        Row row1 = sheet1.getRow(0);//ILK SATIRA GIT

        //ILK SATIR 3. SUTUN'U CREAT ET
        Cell cell3 = row1.createCell(2);//bos olan hucreye gelip tikladim

        //NUFUS YAZ
        cell3.setCellValue("NUFUS");//istedigim degeri atiyorum

        //2.SATIR 3.SUTUNA 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");

        //3.SATIR 3.SUTUNA 350000
        sheet1.getRow(2).createCell(2).setCellValue("350000");

        //KAYDET: KAYIT ISLEMI FILE OUTPUT STREAM ILE YAPILIR
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

    }
}
