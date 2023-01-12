package practice_BurakHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


public class C06_Iframe1 extends TestBase {
    @Test
    public void test01() {
        // ...Exercise 1...
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
        waitFor(3);

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN);
        waitFor(3);

        WebElement iframe = driver.findElement(By.xpath("//div[@class='render']//iframe"));
        driver.switchTo().frame(iframe);

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement videoOynat = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        videoOynat.click();
        waitFor(2);

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazisi = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());
        waitFor(2);

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        WebElement yazi = driver.findElement(By.xpath("//span[.='Powerful, but easy to misuse']"));
        Assert.assertTrue(yazi.isDisplayed());
        waitFor(2);


    }



}
