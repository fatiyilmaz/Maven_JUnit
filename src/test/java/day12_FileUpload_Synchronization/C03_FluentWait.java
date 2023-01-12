package day12_FileUpload_Synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");


        //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();


        //Hello World! Yazının sitede oldugunu test et

        //1.Adim : Fluent Wait icin bir obje olustur
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))//MAX BEKLEME SURESI
                .pollingEvery(Duration.ofSeconds(3))//DENEME ARALIKLARI *30 sn icerisinde 3'er sn araliklarla tekrar tekrar yapacagi islemi yapar.
                .withMessage("IGNORE EXCEPTION")//MESAJ YAZDIRABILIRIM. *Zorunlu degil.
                .ignoring(NoSuchMethodException.class);//EXCEPTION'I (umursama) HANDLE ET. *Zorunlu degil.

        //2.Adim : wait objesini kullanarak bekleme problemini coz.
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);

        //wait.until(ExpectedConditions => suphelendigim durum var elemanin gorunmemesi ve hangi eleman oldugunu yaziyoruz sonrasinda da
        //explicit wait de ve fluent wait de kullanilir.




    }
}
