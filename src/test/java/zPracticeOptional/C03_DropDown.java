package zPracticeOptional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//implicitlyWait Selenyumda vardir, java da yoktur.
        //her sayfa icin max 15 saniye bekler ve yeniler, thread.sleep() nolursa olsun belirttigimiz sure kadar bekler.
    }

    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");


        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);


        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);


        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());


        // Tüm option'ları yazdırın
        int sayac = 1;
        List<WebElement> tumOptionlar = select.getOptions();
        for (WebElement w: tumOptionlar){
            System.out.println(sayac + " . Option" +w.getText());
            sayac++;
        }


        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected = 3;
        int actual = tumOptionlar.size();
        Assert.assertEquals(expected,actual);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
