package practice_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P18_BuyukKucukHarf extends TestBase {
    @Test
    public void name() {
        //google sayfasina gidelim
        driver.get("https://www.google.com");

        //Buyuk kucuk harf olacak sekilde HeLlO yazdiralim
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o",Keys.SHIFT);





    }
}
