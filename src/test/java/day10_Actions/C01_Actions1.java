package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    @Test
    public void rightClick(){
        // TUM ACTIONS'LAR ACTIONS OBJESIYLE BASLAR PERFORM() ILE BITER.

        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");


        //1.Adim: Actions class’ta bir object oluşturulur.
        Actions actions = new Actions(driver);

        //2.Adim: Element'i locate edelim
        WebElement kutu = driver.findElement(By.xpath("//*[@id='hot-spot']"));

        //Kutuya sag tıklayın
        //3.Adim: Actions secimi yapilir perform ile emir verilir.
        actions.contextClick(kutu).perform();
        //actions.contextClick().perform(); => Bu rastgele tiklama yapar.


        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        //Object olusturmak wait gerektiren durumlarda makul
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }


}
