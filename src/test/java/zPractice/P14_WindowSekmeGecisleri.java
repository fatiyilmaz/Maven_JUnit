package zPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P14_WindowSekmeGecisleri extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindow = driver.getWindowHandle();
        System.out.println(amazonWindow);


        //● Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);// Yeni bir sekme acmis olduk
        driver.get("https://www.techproeducation.com");


        //● Sayfa title’nin “TECHPROEDUCATION” icerip, icermedigini test edin
        String title = driver.getTitle();
        String title1 = "TECHPROEDUCATION";
        Assert.assertFalse(title.contains(title1));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);// Yeni bir pencere acmis olduk
        driver.get("https://www.walmart.com");


        //● Sayfa title’nin “Walmart” icerip, icermedigini test edin
        String walmartTitle = driver.getTitle();
        String titleDogrulama = "Walmart";
        Assert.assertTrue(walmartTitle.contains(titleDogrulama));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindow);
        WebElement ilkAcilanSayfa = driver.findElement(By.xpath("//*[@lang='en-us']"));
        Assert.assertTrue(ilkAcilanSayfa.isDisplayed());
        Thread.sleep(3000);


    }
}
