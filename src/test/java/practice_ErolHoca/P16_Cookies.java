package practice_ErolHoca;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P16_Cookies extends TestBase {
    @Test
    public void test01() {
/*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */


        //Techproeducation adresine gidiniz
        driver.get("https://www.Techproeducation.com");

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookielerin Sayisi = "+cookies.size());


        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie w : cookies){
            System.out.println(w.getName()+ " : " + w.getValue());
        }

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("myCookie","123456789");
        driver.manage().addCookie(myCookie);


        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookies1 = driver.manage().getCookies();
        System.out.println("Yeni Cookielerin Sayisi = "+cookies1.size());

        for (Cookie w : cookies1){
            System.out.println(w.getName() + " : " + w.getValue());
        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3 = driver.manage().getCookies();
        System.out.println(cookies3.size());






    }
}
