package homework;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class FakerOdev extends TestBase {


    @Test
    public void FakerTest() {

        //Faker Kutuphanesi HOMEWORK



//Faker class'i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake degerler uretmemize imkan tanir.
//Faker degerler uretmek icin Faker class'indan bir obje uretir ve var olan method'lari kullaniriz.



//"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

//"create new account"  butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();


//"firstName" giris kutusuna bir isim yazin
// "surname" giris kutusuna bir soyisim yazin
//"email" giris kutusuna bir email yazin
//"email" onay kutusuna emaili tekrar yazin
//Bir sifre girin
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
        Faker faker = new Faker();
        driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys(faker.name().firstName()
                , Keys.TAB,faker.name().lastName(),Keys.TAB,faker.internet().emailAddress()
                ,Keys.TAB,faker.number().digits(9),Keys.TAB,Keys.TAB,"30",Keys.TAB,"Mart",Keys.TAB,"2022");

//Cinsiyeti secin
        WebElement erkek = driver.findElement(By.xpath("//input[@value='2']"));
        waitFor(3);
        erkek.click();

        WebElement kadin = driver.findElement(By.xpath("//input[@value='1']"));
//Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(erkek.isSelected());
        Assert.assertFalse(kadin.isSelected());


//Sayfayi kapatin


    }


}
