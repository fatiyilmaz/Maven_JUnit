package practice_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P29_StaleElementReferanceException extends TestBase {
    @Test
    public void name() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Cikan urunlerde sadece Apple iPhone yazanlari tiklayalim
        List<WebElement> urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
        //TEXT ICINDE APPLE IPHONE YAZISI GECENLERI ALACAK
        for (int i = 0; i < urunler.size(); i++) {
            urunler = driver.findElements(By.partialLinkText("Apple iPhone"));//STALE_ELEMENT_REFERANCE_EXCEPTION: attigi icin locate'ini tekrar hatirlattik ve handle ettik.
            urunler.get(i).click();
            driver.navigate().back();

        }
        //StaleElementReferanceException hatasini handle etmek icin loop icine webelementlerden olusturdugumuz list'i koymaliyiz.



    }
}
