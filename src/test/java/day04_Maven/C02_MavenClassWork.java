package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("i[class='icon-signin']")).click();

        //3.Login alanine “username” yazdirin
        driver.findElement(By.cssSelector("input[id='user_login']")).sendKeys("username");

        //4.Password alanine “password” yazdirin
        driver.findElement(By.cssSelector("input[id='user_password']")).sendKeys("password");

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.navigate().back();

        //6.Online Banking butonuna basiniz sonra pay bills sayfasina gidin
       driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
       driver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amount.sendKeys("500");

        //8.tarih kismina “2020-09-10” yazdirin
        //yukarida WebElement'e atayarak yaptim burada da atamadan yaptim
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin (ciktigini kontrol edin derken gorunurlukten bahsediyor)
        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if (mesaj.isDisplayed()){
            System.out.println("Mesaj cikmistir test PASSED");
        }else{
            System.out.println("Mesah cikmamistir test FAILED");
        }

        //11.Sayfayi kapatiniz
        driver.close();





    }
}
