package day13_Exceptions_ScreenshotGiris;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {

    /*
Stale Element means the element is no longer fresh. It is old and no longer available
When the element is no longer fresh on the page and you try to use it
When the element is detached from the DOM
When the element is removed after session started
Solution:
Relocate the same element again. You can use a new variable name as well.
     */

    //StaleElementReferenceException:
    //Cok karsilasilmaz ama interview lerde gelebilir.
    //Stale Elemet -> eski , kullanilamaz durumda , kullanim artik elverisli degil.
    //Sayfayi yenilediginizde (refresh())
    //Sayfada ileri geri gittigimizde

    //Solution: Cozum
    //Elementi tekrar bulmak

    @Test
    public void staleElementReferenceExceptionTest1(){
        driver.get("https://www.techproeducation.com");
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        lmsLoginLink.click();//LMS e git
        Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
        waitFor(5);
//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
        driver.navigate().back();//tekrar ana sayfaya gittik
        waitFor(5);
        lmsLoginLink.click();//LMS e git
        /*

         */


    }

    @Test
    public void staleElementReferenceExceptionTest2() {
            driver.get("https://www.techproeducation.com");
            waitFor(5);
            WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
            waitFor(5);
            driver.navigate().refresh();
            waitFor(5);
            //SAYFA YENILENMEDEN ONCE BULDUGUM ELEMENTI, SAYFA YENILENDIKTEN SONRA KULLANMAK ISTEDIM
            lmsLoginLink.click();// org.openqa.selenium.StaleElementReferenceException

        //Cozum eski (stale element'i) tekrar locate et

    }
}
