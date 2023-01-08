package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
        String actualTitle = driver.findElement(By.xpath("(//*[@id='productTitle'])[1]")).getText();
        String fiyat = driver.findElement(By.cssSelector("div[class='a-section a-spacing-none aok-align-center']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();





    }



        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        //dropdown’dan bebek bölümüne secin
        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        //sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın



}
