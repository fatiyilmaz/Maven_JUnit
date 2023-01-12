package practice_ErolHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P17_Actions1 extends TestBase {
    @Test
    public void test01() {
        /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */


    //http://uitestpractice.com/Students/Actions adresine gidelim
    driver.get("http://uitestpractice.com/Students/Actions");

    //Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement actions = driver.findElement(By.xpath("//*[@class='col col-md-4 col-offset-8']"));
        Actions action = new Actions(driver);
        action.moveToElement(actions).perform();
        waitFor(3);

    //Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        WebElement kutu = driver.findElement(By.xpath("//button[@name='dblClick']"));
        action.doubleClick(kutu).build().perform();
        String alert = driver.switchTo().alert().getText();
        Assert.assertEquals("Double Clicked !!",alert);


    //Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();
        waitFor(3);


    //Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef = driver.findElement(By.xpath("//*[@id='droppable']"));
        action.dragAndDrop(kaynak,hedef).perform();
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[@id='droppable']")).getText());










    }
}
