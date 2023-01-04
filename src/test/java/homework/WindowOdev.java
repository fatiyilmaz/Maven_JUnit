package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class WindowOdev extends TestBase {
    @Test
    public void windowHandle() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        //Title in ‘Windows’ oldugunu test edin
        System.out.println(driver.getTitle());

        //Click here a tiklayin
        driver.findElement(By.xpath("//*[@href='index.php?page=new-windows']")).click();


        Thread.sleep(3000);
        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        String window1Handle = driver.getWindowHandle();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles);

        for (String w : allWindowHandles){
            if (!w.equals(window1Handle)){
               driver.switchTo().window(w);
               break;
            }
        }

        Assert.assertEquals("New Window",driver.getTitle());





    }






}
