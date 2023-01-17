package practice_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P22_Actions3 extends TestBase {
    /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     */

    @Test
    public void name() {
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

        WebElement kutu2 = driver.findElement(By.xpath("//*[@style='left: 100;']"));
        Actions actions2 = new Actions(driver);
        WebElement kirmizi = driver.findElement(By.xpath("//*[@style='left: 0%;']"));
        actions2.clickAndHold(kutu2).dragAndDrop(kutu2,kirmizi).build().perform();

        WebElement kutu = driver.findElement(By.xpath("//*[@style='left: 54.902%;']"));
        WebElement sari = driver.findElement(By.xpath("//*[@style='left: 100%;']"));
        //WebElement kirmizi = driver.findElement(By.xpath("(//span[@tabindex='0'])[2]"));
        actions2.clickAndHold(kutu).dragAndDrop(kutu,sari).build().perform();


    }
}
