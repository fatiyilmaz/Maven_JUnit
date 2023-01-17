package practice_BurakHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C13_FileDownload extends TestBase {
    @Test
    public void test01() {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");


        //2. some-file.txt dosyasini indirelim
        WebElement txt = driver.findElement(By.xpath("//*[@href='download/some-file.txt']"));
        txt.click();



        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
//        String dosyaYolu = "C:\\Users\\yy890\\Downloads\\some-file.txt";
//        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //herkesin pc icin farkli kismi verir.
        String farkliKisim = System.getProperty("user.home"); //=>C:\Users\yy890

        //herkesin pc de aynidir.
        String ortakKisim = "\\Downloads\\some-file.txt"; //=>\Downloads\some-file.txt

        String dosyaYolu2 = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));







    }
}
