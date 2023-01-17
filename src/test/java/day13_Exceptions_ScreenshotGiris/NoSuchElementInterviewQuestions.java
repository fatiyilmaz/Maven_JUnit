package day13_Exceptions_ScreenshotGiris;

public class NoSuchElementInterviewQuestions {

// Interview Questions
/*

Tell me 5 exception that you get.-5 adet selenium da aldigin exceptions dan bahset.
What type of exceptions do you get in selenium? - Seleniumda ki align exceptions tiplerinden bahset
What is your solution?-Cozum ne?
What type of waits do you use?- Hangi resit wait kullanirsin?
Which wait do you prefer?- Hangi wait tercih edersin?
Why do you prefer that wait?- Neden onu tercih edersin?
How to you resolve synronization issue?-Senkronizasyon problemini nasil cozersin?


NoSuchElementException
TimeOutException
NullPointerException
InvalidSelectorException
StaleElementReferenceException
InvalidElementStateException
WebDriverException
ElementNotInteractableException
ElementClickInterceptedException
InvalidArgumentException
JavascriptException
RemoteDriverServerException
 */

    //  NoSuchElementException:
    /*
Yanlis locator
Popup, yeni pencere, iframe,…
Sayfa dolmada problemler ve yavaslamalar
Sakli olan elementler
Solution:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada fluent wait kullaniriz

 */

/*
Tell me 5 exception that you get/What type of exceptions do you get in selenium?
Null pointer, no such element, time out, slate element reference, web driver
What is your solution?
Read the error message and learn what is the error and where it is.
In general, error happens because of the timing issue, wrong locator, or iframe/windows/alerts
Each error has specific solutions but in general, I debug my code, and do some research then execute the code one more time after the fix.
What type of waits do you use?
I use implicit or explicit wait
Which wait do you prefer?
Explicit wait works better in some cases. When I use explicit wait, and still see timeout exception, then then there can be other issues such as incorrect locators.
Why do you prefer that wait?
I already have implicit wait in my Driver class, but I prefer explicit wait when I need to use an expected condition such as element is not visible.
How do you resolve synronization issue?
I use implicit or explicit wait. In my driver class, I already have implicit wait, that handles most of the wait issues, but when it is not enough than I use explicit wait.
 */

    /*
         Selenium da aldigin 5 exception nedir ?
         NullPointer, NoSuch, TimeOut, StaleElementReference, WebDriver

         Genel olarak exception aldiginda cozum yolun nedir ?
         *Hata mesahini okurum.
         *Genel olarak yanlis locator,zamanlama, iframe hatalari olabiliyor.
         *Hata mesajina gore exception'i cozdukten sonra tekrar kodumu calistirip bakarim.


         Seleniumda kullandigin waitler nelerdir ?
         implicit wait yada explicit wait yada fluent wait

         Hangi wait'i tercih edersin ?
         Test Base (Driver sinifinda) implicit wait kullaniyorum. Cogu problemi cozuyor, cozemedigi durumlarda
         explicit wait kullaniyorum.

         Neden Explicit wait ?
         Explicit wait element'e ozel yazilabilir. Yerel cozum gerektiginde explicit wait'i kullanmak zorundayiz.

         Senkronize(bekleme) problemlerini nasil cozersin ?
         Selenium waitlerini kullanarak. Implicit wait driver'imda var yetmedigi durumlarda explicit wait kullanirim.
         Bu yuzden Reusable Method sinifimda tekrar tekrar kullanabilecegimiz explicit wait methodlari var.
         Kolaylikla explicit wait ile bekleme problemlerini cozebiliyoruz.
     */


}
