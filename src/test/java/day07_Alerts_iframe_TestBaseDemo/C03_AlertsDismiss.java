package day07_Alerts_iframe_TestBaseDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_AlertsDismiss extends TestBase {

    @Test
    public void dismissAlertTest() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // 2. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        Thread.sleep(5000);


        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();//cancel secenegine tikliyoruz
        Thread.sleep(5000);


        // ve result mesajının “You clicked: Cancel” oldugunu test edin.
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();//gercek deger
        String expectedResult = "You clicked: Cancel";//beklenen deger
        Assert.assertEquals(actualResult,expectedResult);





    }




}
