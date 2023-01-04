package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class IframeOdev extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        //sayfadaki toplam iframe sayısını bulunuz.
        int iFrameSayisi = driver.findElements(By.tagName("iframe")).size();
        System.out.println("The total number of iFrame : " + iFrameSayisi);


        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualResult = driver.findElement(By.xpath("//*[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expectedResult = "Editor";
        Assert.assertTrue(actualResult.contains(expectedResult));

        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        WebElement silVeEkle = driver.findElement(By.xpath("(//*[.='Your content goes here.'])[3]"));
        silVeEkle.clear();

        //Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        Thread.sleep(3000);
        silVeEkle.sendKeys("iframein icindeyim", Keys.ENTER);

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        Thread.sleep(3000);
        driver.switchTo().parentFrame();
        String textName = driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();
        Assert.assertTrue(textName.contains("Elemental Selenium"));

//        driver.switchTo().defaultContent();
//        String altyazi = driver.findElement(By.xpath("//*[@style='text-align: center;']")).getText();
//        String altyazi1 = "Elemental Selenium";
//        Assert.assertTrue(altyazi.contains(altyazi1));



    }









}
