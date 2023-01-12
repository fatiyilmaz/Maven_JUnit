package day07_Alerts_iframe_TestBaseDemo;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    /*
         UTILITES:
         -Utilities tekrar tekrar kullanacagimiz classlari koydugumuz paketin adidir.
             -TestBase
             -Driver        ->Sonra
             -ExcelUtil     ->Sonra
             -Configuration ->Sonra
        -Utilities paketinde Test Case'ler yazilmaz.
        -Sadece tekrar kullanilabilecek destek siniflari(support classlar) olusturulur.
        -Bu support classlar test caseslerin yazilmasini hizlandirir.
     */

    @Test
    public void test01(){

        //techproeducation ana sayfasina git
        driver.get("https://www.techproeducation.com");

        //ve titlein Bootcamps kelimesini icerdigini test edelim
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));

    }

}
