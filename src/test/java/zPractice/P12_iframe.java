package zPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P12_iframe extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // - https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow = driver.getWindowHandle();


        //src iframe'in icindekine gecis yapmadan direkt tiklar -> iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']
        //*[@class='render']/iframe  -> bu kod ise class render'in altindaki iframe anlamina gelir


        //  - youtube videosunu çalıştırınız
        WebElement iframe = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();


        //  - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();


        //  - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //  - iphone aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);


        //  - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String[] aramaSonucu = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText().split(" ");
        System.out.println("aramaSonucu = " + aramaSonucu[2]);

        //  - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkWindow);
        System.out.println("ilk Window Url'i = " + driver.getCurrentUrl());
        Thread.sleep(3000);

        //  - ilk sekmeyi kapatalım
        driver.close();
        Thread.sleep(3000);

        //  - Sonra diğer sekmeyide kapatalım
        //driver.quit(); => @TestBase'deki aftar icindeki driver.quit'im calisacak



    }


}
