package practice_ErolHoca;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P33_ReadExcel {
    @Test
    public void name() throws IOException {
        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String dosyaYolu = "C:/Users/yy890/OneDrive/Masaüstü/data.xlsx/";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);


        //https://www.bluerentalcars.com/ adresine gidip
        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        //Login olduğumuzu doğrulayalım
    }


}
