package practice_ErolHoca;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P30_ScreenShot extends TestBase {
    String tarih;
    @Test
    public void name() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //Tüm sayfanın resmini alalım
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
        waitFor(3);
        /*
            FileUtils CLASS'I, FILE NESNELERI ILE BIRLIKTE KULLANABILECEGIMIZ METHODLAR ICERIR.
            BU METHODLARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ.
         */

        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        waitFor(6);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

        //Tekrar amazon sayfasına dönüp iphone aratalım
        driver.navigate().back();

        //Arama sonucunun resmini alalım => sonuc elementini locate edip webelemente assine edin yukaridaki File Utilsi kullanin.




    }
}
