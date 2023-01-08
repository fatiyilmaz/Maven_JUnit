package day09_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {
    @Test
    public void windowHandleTest() {

        //        https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //        Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindow1Text = driver.findElement(By.xpath("//h3")).getText(); //text yazisinin tag'ini aldim 1 of 1
        String expectedWindow1Text = "Opening a new window";
        Assert.assertEquals(expectedWindow1Text,actualWindow1Text);


        //        Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualWindow1Title = driver.getTitle();
        String expectedWindow1Title = "The Internet";
        Assert.assertEquals(expectedWindow1Title,actualWindow1Title);


        //String window1Handle = driver.getWindowHandle(); //id yi verir, tekrar donmek istersem bunu kullanmak icin olustururum

        //        Click Here butonuna basın.
        driver.findElement(By.xpath("//*[@href='/windows/new']")).click();

        waitFor(3);

        // Ikinci pencere acilir ve ikinci pencerede islem yapmak istedigimden, 0 pencereye switch-gecis-yapmaliyiz

        switchToWindow(1);//2. windowa gecis yaptik. driver artik 2. window da

        //        Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualWindow2Title = driver.getTitle();
        String expectedWindow2Title = "New Window";
        Assert.assertEquals(expectedWindow2Title,actualWindow2Title);






    }
}
