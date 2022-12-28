package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

                // ODEV;


                // 2- https://www.google.com/ adresine
        driver.get("https://www.google.com/");

               // gidin 3- cookies uyarisini kabul ederek kapatin


               //4Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

               //5Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);


                //6Bulunan sonuc sayisini yazdirin
        WebElement result = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(result.getText());

                //7sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
//        String[] myList = result.getText().split(" ");
//        String sonuc = Integer.parseInt(myList[1].replace(".","")) > Integer.parseInt("10000000") ?
//                "Test PASSED" : "Test FAILED";
//        System.out.println("Sonuc 10 milyon'dan fazla mi? : " + sonuc);

        //split methodu sadece Array dondurur
        String[] yeniR = result.getText().split(" ");
        System.out.println(Arrays.toString(yeniR));
        int sayi = Integer.parseInt(yeniR[1].replace(".",""));
        int sayi2 =Integer.parseInt("10000000");
        if(sayi>sayi2){
            System.out.println("test is passed");
        }else System.out.println("test is failed");

               //8Sayfayi kapatin
        driver.close();



    }

}