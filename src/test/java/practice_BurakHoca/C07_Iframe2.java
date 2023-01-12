package practice_BurakHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_Iframe2 extends TestBase {

    @Test
    public void Test01() {
        // ...Exercise 2...
        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isEnabled());
        System.out.println(text.getText());

        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textYazisi = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textYazisi.clear();
        textYazisi.sendKeys("Merhaba Dunya");


        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[@href='http://elementalselenium.com/']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());


    }
}
