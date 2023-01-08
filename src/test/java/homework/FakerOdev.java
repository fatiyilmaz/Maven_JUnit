package homework;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        Faker faker = new Faker();
        driver.findElement(By.xpath("(//[@type='text'])[2]")).sendKeys(faker.name().firstName()
                , Keys.TAB,faker.name().lastName(),Keys.TAB,faker.internet().emailAddress()
                ,Keys.TAB,faker.random().toString(),Keys.TAB,faker.date().birthday().toString());


//"surname" giris kutusuna bir soyisim yazin
//"email" giris kutusuna bir email yazin
//"email" onay kutusuna emaili tekrar yazin
//Bir sifre girin
//Tarih icin gun secin
//Tarih icin ay secin
//Tarih icin yil secin
//Cinsiyeti secin
//Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//Sayfayi kapatin


    }


}
