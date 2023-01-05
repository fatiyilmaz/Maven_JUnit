package zPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P08_DropdownSendKeysKullanimli extends TestBase {


    @Test
    public void dropDown() throws InterruptedException {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Dropdown menuyu yazdiralim
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdown.stream().forEach(t-> System.out.println(t.getText()));


        //dropdown menuden baby secelim
        //arama bolumunden milk aratalim
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);
        Thread.sleep(3000);

        /*
            Erol hoca yukaridaki ornekte dropdown'daki 3 asamayi kullanmadan obje olusturmadan kisa yol kullanimini gosterdi.
         */






    }
}
