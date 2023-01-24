package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_JSExecutor_Type extends TestBase {
    @Test
    public void typeTest() {
        //1) typeTest methodu olustur

        //2) Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com/");
        waitFor(3);

        //arama kutusuna QA yaz
        typeWithJS(driver.findElement(By.xpath("//input[@title='Search']")),"QA");



    }

}
