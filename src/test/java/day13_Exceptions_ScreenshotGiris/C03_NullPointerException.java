package day13_Exceptions_ScreenshotGiris;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class C03_NullPointerException {

    /*
NullPointerException
When a variable is created, but not instantiated, when pointer does not show any value then we get NullPointerException.
It is common to initialize the Driver, they we get the extaction. Driver driver; but never use driver=new ChromeDriver()
For example, in my page object model, I create page objects in test classes but when I forgot to use new keyword to instantiate, then I get the exception
Solution:
Instantiate the variable
     */


    //NullPointerException
    //Degiskenleri olusturup instantiate etmedigimizde aliriz (new kelimesini kullanmadigimizda)
    //Örn: driver = new ChoromeDriver()'da "new" kelimesini kullanmadığımızda NullPointerException hatasını alırız.

    //Instantiate -> driver = new ChromeDriver => ne kullanacagini biliyor. -> Cunku objeyi Instantiate etmis olduk.
    //driver.get("") => ne kullanacagini bilmiyor "NullPointerException" alir.


    //Solution: => Çözüm
    //Degiskeni instantiate et

    WebDriver driver;
    Faker faker; //Faker faker = new Faker();
    @Test
    public void nullPointerExceptionTest(){
        driver.get("https://www.techproeducation.com");//java.lang.NullPointerException


    }

    @Test
    public void nullPointerExceptionsTest2(){
        //faker=new Faker(); => kafasi karismaz.
        System.out.println(faker.name().fullName());//java.lang.NullPointerException

    }

}
