package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class IframeVeActionsOdev extends TestBase {

    @Test
    public void KeyboardActions2Test() {

        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement iframeGiris = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframeGiris);

        WebElement oynat = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        oynat.click();


        //videoyu calistirdiginizi test edin
        Assert.assertTrue(oynat.isEnabled());




    }
}
