package day09_Window_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest(){
        //WindowType.WINDOW, ve WindowType.Tab selenium 4 de var oldu ,
        //selenium 3 de bu olaylar da navigate kullaniliyordu ve driver yenileniyordu

        //1. Techproeducation sayfasinin title'in "Techpro Education" metnini icerdigini test edin
        driver.get("https://www.techproeducation.com");

        String techProHandle = driver.getWindowHandle();

        //1.Cozum Yolu;
//        String actualsayfaTitle = driver.getTitle();
//        String expectedSayfaTitle = "https://www.techproeducation.com";
//        Assert.assertTrue(actualsayfaTitle.contains(expectedSayfaTitle));

        //2.Cozum Yolu;
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));



        //2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edelim
        waitFor(3);

        driver.switchTo().newWindow(WindowType.WINDOW);//1. Yeni pencere olusturur. 2. Oraya gecis yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));



        //3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedIn.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        waitFor(3);


//        DRIVER NERDE? LINKEDINDE
//        TECHPRO SAYFASINA GITMEK ICIN TEKRAR driver.switchTo().window(techProHandle)
        driver.switchTo().window(techProHandle);
        waitFor(3);


//        DRIVER NERDE? TECHPRODA
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);


    }

}
