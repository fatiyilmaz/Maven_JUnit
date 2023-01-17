package day14_Screenshot_ExtentReports;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {

    @Test
    public void fullPageScreenshorTest() throws IOException {
        /*
            Selenium da tum ekran goruntusu nasil alinir ?
            *Tum ekran goruntusu seleniumdan gelen getScreenshotAs methodu ile alinir.
            *getScreenshotAs methodu seleniumdaki TakesScreenshot api'indan gelir.

         */

        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

        //1. Ekran goruntusunu getScreenshotAs methodu ile alip File olarak olusturalim.
        //TakesScreenshot'i selenium sayesinde kullaniyorum.
        File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//ekran goruntusunu seleniumun sundugu 3 yoldan birini seciyorum FILE(Dosya) ile aliyorum.

        //2. Almis oldugum ekran goruntusunu belirledigim bir PATH e kaydet.
        //user.directory(user.dir) = user dosyasi demektir.
        //NOTE: kayit ismini dinamik yapmak icin date objesi kullandim.
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentDate+"image.png";
        File hedef = new File(path);

        //3. Goruntum ile dosyami birlestirip kaydet.
        FileUtils.copyFile(goruntu,hedef);

        //ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
//                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path

        //-“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA", Keys.ENTER);

        waitFor(3);
//        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));


        //Reusable method yardimiyla ekran goruntusunu alalim
        takeScreenShotOfPage();




    }
}
