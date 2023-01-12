package practice_ErolHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05_SayfalardaBeforeAfter {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {

        //BeforeClass ile driver ı olusturun ve
        //Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    //http://www.google.com adresine gidin
    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");

    }


    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01() {
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("The God Father", Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//*[@id='result-stats']")).getText());
    }


    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test02(){
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord of the Rings", Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//*[@id='result-stats']")).getText());
    }


    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test03(){
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill", Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//*[@id='result-stats']")).getText());
    }


    @After
    public void tearDown() throws Exception {
        String [] sonuc =driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        System.out.println("Arama Sonuc Sayisi = "+sonuc[1]);
    }


        //AfterClass ile kapatın
    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }




}
