package day06_Dropdown_DropdownReusable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReusable {

    //REUSABLE METHOD: Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalim.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    public void selectFromDropdown(WebElement dropdown, String secenek){
        //selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']"));,"2005"); -> yil'dan 2005 sececek
        //selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']"));,"January"); -> ay'dan january sececek
        //selectFromDropdown(driver.findElement(By.xpath("//select[@id='day']"));,"12");->gun'den 12 sececek

        //Gonderilen dropdown elementinin tum optionslari alinir.
        List<WebElement> options = dropdown.findElements(By.tagName("option"));//Tum opton tagli elementleri aliyorum
        for (WebElement eachOption : options){
            if (eachOption.getText().equals(secenek)){
                eachOption.click();
                break;
            }
        }
    }

    @Test
    public void selectFromDropdown(){
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")),"2005");//2005 secti
        selectFromDropdown(driver.findElement(By.xpath("//*[@id='month']")),"November");//November secti
        selectFromDropdown(driver.findElement(By.xpath("//*[@id='day']")),"10");//10 secti
        selectFromDropdown(driver.findElement(By.id("state")),"Texas");

    }




    //Note: Sonraki derste tekrar ve kullanimi olacak

    /*
        Dropdown?
        -Acilir menu. Birden fazla secenegi koyabilecegimiz liste.

        Dropdown nasil automate edilir? How to handle dropdown?
        //tercih edilmez , sirasi degisebilir
        //kullanilabilir ama bazen value attribute dropdownlarda olmaz
        //Gorunen yazilir , her zaman kullanilmasi gerekendir

        Dropdown?
        -Acilir menu. Birden fazla seçenegi koyabilecegimiz liste.

        ***Dropdown nasil automate edilir? How to handle dropdown?
        Dropdown elementi locate edilir.8 locatordan biri kulllaninbilir.
        Select classi kullanilarak bir Select objesi olusturulur. Select select = new Select(dropdownElement);
        Select objectini kullanarak ugun methodlarla islem yapilir
        selectBylndex(int); index 0 dan baslar
        selectByValue(“String”);
        selectByVisibleText(“String”);
        getOptions(); tum dropdown seçenekleri List<WebElement> olarak return eder
        getFirstSelectedOption(); secili olan ilk secenegi(default) return eder.
     */
}
