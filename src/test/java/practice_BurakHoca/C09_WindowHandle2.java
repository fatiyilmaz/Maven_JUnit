package practice_BurakHoca;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C09_WindowHandle2 extends TestBase {
    @Test
    public void test02() {

        // ...Exercise 2...


        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String window1Handle = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));


        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String window2Handle = driver.getWindowHandle();


        // 4- title'in 'Best Buy' icerdigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(window1Handle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String actualSonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expectedSonuc = "Java";
        Assert.assertFalse(actualSonuc.contains(expectedSonuc));


        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(window2Handle);


        // 8- logonun gorundugunu test edelim
        driver.findElement(By.xpath("//img[@class='logo']")).isDisplayed();


    }
}
