package day09_Window_BasicAut_Cookies;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest(){

        //Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);


        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies =  driver.manage().getCookies();//toplam cookie sayisi
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada "+cookieSayisi+ " adet cookie var");


        //3. Bir Cookie yi ismiyle bul

        //tum cookie'leri yazdiralim

        //allCookies.stream().forEach(t-> System.out.println(t.getName())); =>  Lambda yapilisi

        int sayi = 1;
        for (Cookie eachCookie : allCookies){
            System.out.println(sayi +" COOKIE :"+eachCookie);//cookie'nin tamamini yazdik
            System.out.println("COOKIE ISIMLERI : " +eachCookie.getName());//=> For each yapilisi
            sayi++;
        }

        System.out.println("COOKIEYI ISMIYLE CAGIRIYORUM : " +driver.manage().getCookieNamed("i18n-prefs"));

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("Cikolata","antem-fistikli-cikolata");
        driver.manage().addCookie(favoriCookiem);
        waitFor(3);
        System.out.println("Yeni Cookie Sayisi : "+driver.manage().getCookies().size());

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : "+driver.manage().getCookies().size());

        //Yukarida gecici olarak browser da otomatize etmis olduk yeni bir pencereden actigimda yine ayni islemleri yapmam gerekir.
    }
}
