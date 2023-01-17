package day13_Exceptions_ScreenshotGiris;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
TimeOutException:
If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
Simply put, wait time is over but the commend is not completed
Solution:
-Increase the wait time
-Try using different wait. For example try using javascript executor wait for the page to load. This is also a dynamic wait
-I have different explicit waits in my Reusable util class. I have javascript executor wait as well. ReusableMethods.waitForPageToLoad(1);
-Case by case, I prefer different explicit waits to maximize the performance of the automation script
     */

    //TimeOutException:
    //Explicit wait kullanildiginda, ve element bulunamadiginda "TimeOutException" alinir.
    //Explicit wait & yanlis locator -> "TimeOutException" alinir.
    //Explicit wait & dogru locator & sure yeterli degil -> "TimeOutException" alinir.
    //Explicit wait & dogru locator & sure yeterli & iframe var -> "TimeOutException" alinir.
    //Explicit wait gordugumuz yerde "TimeOutException" alinir diyebiliriz.

    //Solution: => Çözüm
    //Sureyi arttirmak
    //Her sey dogru oldugu halde hata varsa farkli Explicit wait, cesidi kullanilabilir
    //wait visibilityOfElementLocated yerine presenceOfElementLocated. Yada javascript executer'daki waitte sayfa gecislerini beklemek icin kullanabilirim
    //Locater'i yekrar kontrol etmek
    //Frameworkunde hazir reusable methodlar var bu durumda timeoutexception aldigimda hizlica o methodlar yardimiyla problemi cozebiliyoruz


    @Test
    public void timeOutException() {
        driver.get("https://www.techproeducation.com");

        //Explicit wait icin olusturdugumuz methodlardan birini kullanalim.
        //Parametre 1: Beklemek istedigim element, Parametre 2: Max sure
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));// => selenium.TimeoutException aldim.
/*
        TimeOutException, explicit wait kullandigimda ve locator bulunamadiginda alirim
 */













    }
}
