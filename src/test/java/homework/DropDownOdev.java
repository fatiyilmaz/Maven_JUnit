package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class DropDownOdev extends TestBase {

    @Test
    public void Test01() {

        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w: allOptions){
            System.out.println(w.getText());
        }


        //dropdown menude 40 eleman olduğunu doğrulayın
        int toplamOptions = allOptions.size();
        Assert.assertNotEquals(40,toplamOptions);

    }
    static String ikinciUrunTitle;
    static String ikinciUrunPrice;

    @Test
    public void Test02() {
        //Test02
        driver.get("https://www.amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        String[] sonucSayisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
        System.out.println("Iphone Sonuc Sayisi : "+sonucSayisi[3]);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String sonucSayisi1 = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(sonucSayisi1.contains("iphone"));

        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        WebElement altUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[9]"));
        WebElement ikinciUrun = driver.findElement(with(By.xpath("(//*[@class='s-image'])[2]")).toRightOf(ilkUrun).above(altUrun));
        ikinciUrun.click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String ikinciUrunTitle = driver.findElement(By.xpath("(//*[@id='productTitle'])[1]")).getText();
        String ikinciUrunPrice = driver.findElement(By.cssSelector("div[class='a-section a-spacing-none aok-align-center']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();

    }


    @Test
    public void test03() {
        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //dropdown’dan bebek bölümüne secin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Baby");

        //bebek puset aratıp bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        String[] result = driver.findElement(By.xpath("//*[text()='1-16 of 22 results for']")).getText().split(" ");
        System.out.println("Sonuc Sayisi = "+result[2]);


        //sonuç yazsının puset içerdiğini test edin
        String actualResult = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        String expectedResult = "puset";
        Assert.assertTrue(actualResult.contains(expectedResult));


        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[2]"));
        WebElement ucuncuUrun = driver.findElement(with(By.xpath("(//*[@class='s-image'])[3]")).below(ikinciUrun));
        ucuncuUrun.click();



        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        String ucuncuUrunTitle = driver.findElement(By.xpath("(//*[@id='productTitle'])[1]")).getText();
        String ucuncuUrunPrice = driver.findElement(By.xpath("//span[@class='a-offscreen']")).getText();
        WebElement sepeteUrunEkle = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
        sepeteUrunEkle.click();


        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
//        WebElement sepeteUrunEkle = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
//        sepeteUrunEkle.click();
//        WebElement sepeteGit = driver.findElement(By.xpath("//*[@href='/gp/cart/view.html?ref_=sw_gtc']"));
//        sepeteGit.click();
//
//        String urunIsim= driver.findElement(By.xpath("//span[@class='a-truncate-full']")).getText();
//        String urunFiyat = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")).getText();

        Assert.assertNotEquals(ikinciUrunTitle,ucuncuUrunTitle);
        Assert.assertNotEquals(ikinciUrunPrice,ucuncuUrunPrice);





    }
}
