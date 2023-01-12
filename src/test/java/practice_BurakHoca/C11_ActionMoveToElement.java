package practice_BurakHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C11_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String window1handle = driver.getWindowHandle();


        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dropdownMenu = driver.findElement(By.xpath("//*[@id='icp-nav-flyout']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdownMenu).perform();


        // Change country/region butonuna basiniz
          WebElement country = driver.findElement(By.xpath("(//a[@href='/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/'])[1]"));
          actions.moveToElement(country).click().build().perform();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("(//span[@class='a-text-bold'])[3]")).click();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        String window2 = "";
        Set<String>allwindow = driver.getWindowHandles();
        for (String w: allwindow){
            if (!w.equals(window1handle)){
                window2=w;
            }
        }

        driver.switchTo().window(window2);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Elektronik";
        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }
}
