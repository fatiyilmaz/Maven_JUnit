package practice_BurakHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C08_WindowHandle extends TestBase {

    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String window1Handle = driver.getWindowHandle();


        // 2- nutella icin arama yapın
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("nutella", Keys.ENTER);


        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        WebElement searchBox1 = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox1.sendKeys("nutella", Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();


        // 4- yeni tab'da acilan urunun basligini yazdirin
        WebElement productTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println("Baslik : " +productTitle.getText());

        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(window1Handle);
        System.out.println("Ilk sayfa url : " +driver.getCurrentUrl());


    }
}
