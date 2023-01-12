package practice_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class P19_Actions2 extends TestBase {
    @Test
    public void name() {

        //-http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");
        String window1Handle = driver.getWindowHandle();


        //-Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement aboutUs = driver.findElement(By.xpath("//*[.='About Us']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aboutUs).perform();
        driver.findElement(By.xpath("//*[text()='Fleet']")).click();
        waitFor(3);

        //-Sayfa başlığının Fleet içerdiğini test edelim
        String window2handle;
        Set<String> allwindow = driver.getWindowHandles();
        for (String w : allwindow){
            if (!w.equals(window1Handle)){
                window2handle=w;
                driver.switchTo().window(window2handle);
            }
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Fleet";
        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }
}
