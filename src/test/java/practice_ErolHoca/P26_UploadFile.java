package practice_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P26_UploadFile extends TestBase {
    @Test
    public void name() {

        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");

        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
        WebElement path = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        String dosyaYolu = "C:\\Users\\yy890\\OneDrive\\Masaüstü\\logo.jpeg";
        path.sendKeys(dosyaYolu);

        //  HOCANIN COZUMU
//        "C:\Users\Lenovo\OneDrive\Masaüstü\sen.txt" //DOSYANIN GERÇEK YOLUNU ALIP GÖREBİLMEK BURAYA KOYDUK
//        String farkliKisim = System.getProperty("user.home");//C:\Users\Lenovo
//        String ortakYol = "\\OneDrive\\Masaüstü\\sen.txt";
//        String dosyaYolu = farkliKisim+ortakYol;

//        String dosyaYolu1 = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\sen.txt";
//        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadfile_0']"));
//        dosyaSec.sendKeys(dosyaYolu);

        // I accept terms of service bölümünü tikleyin
        driver.findElement(By.xpath("//*[@id='terms']")).click();


        // Submit File buttonuna basınız
        driver.findElement(By.xpath("//*[@id='submitbutton']")).click();

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        waitFor(2);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }
}
