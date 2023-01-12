package day07_Alerts_iframe_TestBaseDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {

    //Bir class olusturun: Alerts
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert


    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    @Test
    public void acceptAlertTest() throws InterruptedException {

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(3000);
        driver
                .switchTo()//degistir
                .alert()//alerte degistir
                .accept();//ok secenegine tiklanir
        Thread.sleep(3000);

//        ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);




    }







    /*
        Alertleri nasil automate edersin? How to handle alerts in selenium?
        -Alertler javascript ile olusur. Inspect(incele) edilemezler. Oncelikle alerte switch etmemiz gerekir.
     */
}
