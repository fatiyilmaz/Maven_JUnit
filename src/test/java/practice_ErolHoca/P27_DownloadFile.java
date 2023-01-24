package practice_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P27_DownloadFile extends TestBase {
    @Test
    public void name() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");


        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        WebElement browser = driver.findElement(By.xpath("//button[@aria-controls='supported-browsers']"));
        actions.moveToElement(browser).perform();
        browser.click();


        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        WebElement chrome = driver.findElement(By.xpath("//*[@href='https://chromedriver.chromium.org/']"));
        chrome.click();


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("//*[text()='ChromeDriver 109.0.5414.74']")).click();
        List<String>pencereler = new ArrayList<>(driver.getWindowHandles());
        for (String w: pencereler){
            driver.switchTo().window(pencereler.get(1));
        }
        //Açılan pencerede chromedriver'i indirelim
        driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']")).click();
        waitFor(10);

        //Driver'in indiğini doğrulayalım
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\chromedriver_win32.zip";
        assert Files.exists(Paths.get(dosyaYolu));//Files.exists dosyanin inip inmedigini kontrol ediyor


    }
}
