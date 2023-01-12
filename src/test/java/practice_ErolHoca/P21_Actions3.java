package practice_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P21_Actions3 extends TestBase {
    @Test
    public void name() {

    //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
    driver.get("http://szimek.github.io/signature_pad/");
        Actions actions = new Actions(driver);

    //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement gotur = driver.findElement(By.xpath("//*[@id='signature-pad']"));
//        actions.moveToElement(gotur).perform();

//        WebElement sekil = driver.findElement(By.xpath("//*[@width='250']"));
//        WebElement ciz = driver.findElement(By.xpath("//*[@height='200']"));

        int sekil = 360;
        for (int i = 1; sekil < 360; i++) {
            actions.moveToElement(gotur).moveByOffset(i,sekil).release().build().perform();

        }






    //- Çizimden sonra clear butonuna basalım



    //- Son olarak sayfayı temizleyiniz

    }
}
