package practice_BurakHoca;

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

public class C02_DropDownOptions {

    // ...Exercise 2...



   // dropdown'dan "Baby" secenegini secin
   // sectiginiz option'i yazdirin
   // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        //1- locate edilmeli
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2-Select objesi olusturulmalı
        Select select=new Select(ddm);

        //3-opsiyon secilir
        select.selectByVisibleText("Baby");


        // sectiginiz option'i yazdirin
        String sectigimOption=select.getFirstSelectedOption().getText();
        System.out.println("SECTİGİ MOPTİON : " + sectigimOption);



        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

        List<WebElement> tumOptionlar=select.getOptions();

        int actuelOptionSayısı=tumOptionlar.size();
        int expectedOptionSayısı=28;


        Assert.assertEquals(expectedOptionSayısı,actuelOptionSayısı);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
