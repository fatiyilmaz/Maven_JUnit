package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //TestBase'i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum,
    //TestBase testBase = new TestBase(); bu objeyi yapmak istemiyorum.
    //Benim istegim bu sinifi extend etmek ve icindeki hazir methodlari kullanmak.

    //driver objesini olustur. Driver ya public yada protected olmali. Sebebi child classlar'da gorulebilir olmasi.
    protected static WebDriver driver;// statik yazmasak olurdu ama static kullanma sebebimiz tum framework'de ortak olarak kullanicaz.

    //setUp
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    //tearDown
    @After
    public void tearDown(){
        driver.quit();
    }


    //    MULTIPLE WINDOW
    //Bu method 1 parametre alir : Gecis yapmak istedigim sayfanin title'i
    //ORNEK:
    //driver.get("https://the-internet.herokuapp.com/windows")
    //switchToWindow("New Window");
    //switchToWindow("The Internet");

    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }



}
