package practice_ErolHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03_HesapMakinesi {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

// https://testpages.herokuapp.com/styled/index.html adresine gidin
// Mikro Uygulamalar altında Hesapla'ya tıklayın
// İlk girişe herhangi bir sayı yazın
// İkinci girişe herhangi bir sayı yazın
// Hesapla'ya tıklayın
// Sonucu yazdır
// sürücüyü kapat


        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //Click on  Calculate under Micro Apps
        driver.findElement(By.xpath("//*[@id='calculatetest']")).click();

        //Type any number in the first input
        //Type any number in the second input
        //Click on Calculate
        WebElement firstNumber = driver.findElement(By.xpath("//*[@id='number1']"));
        firstNumber.sendKeys("30", Keys.TAB,Keys.TAB,"30",Keys.TAB,Keys.ENTER);

        //Print the result
        WebElement toplamSonucuYazdir = driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println("toplamSonucuYazdir = " + toplamSonucuYazdir.getText());

        //close driver
        driver.close();




    }
}
