package zPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P10_iframeListVeTumuneTiklama extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);


        // ikinci emojiye tıklayın
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();
        Thread.sleep(3000);

        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id='nature']//img"));

        emojiler.stream().forEach(t->t.click());//Lambda ile tum webelementlere tikladik

//        for (WebElement w: emojiler){
//            w.click();
//        }

        Thread.sleep(3000);


        // parent iframe e geri donun
        driver.switchTo().parentFrame();

        //driver.navigate().refresh(); //default content gibi en basa doner bu sekilde de iframe'den cikis yapilabilir.

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        //driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Erol");

        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String>veriler = new ArrayList<>(Arrays.asList("Erol","Evren","selenium","lambda","java","sql","gitgithub","dff","Sadgas","sdags","asdads"));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }

        Thread.sleep(3000);


        //  apply button a basin
        driver.findElement(By.xpath("//*[.='Apply']")).click();
    }


}
