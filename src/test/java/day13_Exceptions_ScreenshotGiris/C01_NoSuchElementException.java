package day13_Exceptions_ScreenshotGiris;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementTest(){

        //implicit wait kullanildiginda, ve element bulunamadiginda "NoSuchElementException" alinir
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//input[@type='searchh']")).sendKeys("QA"+ Keys.ENTER);
        //locate yanlis oldugu icin seleniumdan => selenium.NoSuchElementException hatasi alindi.
        //bu durumda yapilacak adim;
        //kodu kopyala,
        //kodu html kodlarinin arasina yapistir ve gozukecek mi diye bak gozukmuyorsa yanlis locate'i duzelt.




    }

}
