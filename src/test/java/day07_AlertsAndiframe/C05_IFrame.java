package day07_AlertsAndiframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest() {

        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin 'black border' yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        String expectedText = "black border";
        Assert.assertTrue(anaMetin.contains(expectedText));




        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim

        //applications lists elementi iframe'in icinde.Iframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar. Ilk iframe'e switch yapiyoruz

        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1 = "Applications lists";
        Assert.assertEquals(expectedText1,icMetin);





        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

        //Ana sayfadaki Powered By yazisini test etmek istiyorum ama driver hala iframein icinde Iframein disina cikmak
        //icin driver.switchTo().defaultContent() veya parentFrame() kullaniriz.
        //driver.switchTo().defaultContent() en disa cikar, buyuk buyuk baba.
        //driver.switchTo().parentFrame() disa cikar, baba.

        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        //                                                             footer'i ver onun altinda p tagi var onu ver
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));


    }





}
