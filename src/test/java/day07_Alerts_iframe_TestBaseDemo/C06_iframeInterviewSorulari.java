package day07_Alerts_iframe_TestBaseDemo;

public class C06_iframeInterviewSorulari {

    /*
        Bir sayfadaki toplam iframe sayisini nasil buluruz?
        ***Iframler iframe tagi kullanilarak olusturulur. Bu durumda eleman find elements by frame loctorini kullanarak
        ***tum iframeleri bulurum.
        ***driver.findElements(By.tagName("iframe")); tum iframeleri liste olarak verir.
        ***driver.findElements(By.xpath("//iframe"));



        Tekrar ana sayfaya nasil donersin?
        ***2 farkli yol vardir.
        ***DefaultContent yada parentFrame methodlarini kullanarak switch(gecis) yapabiliriz.



        DefaultContent ve parentFrame arasindaki fark nelerdir?
        ***Oncelikle her ikiside frame'in disina cikmamizi saglar. Ama defaultContent ana sayfaya atlatir,
        ***parentFrame ise bir ust seviyeye atlatir.



        Bir test case'in fail etme sebebepleri neler olabilir?(Onemli Soru)
        1.Yanlis locator. Cozum => Tekrar elementi locate etmek. Degisken element var ise ona gore dynamic bir xpath yazariz.

        2.Wait/Syncronization /Bekleme problemi. Cozum => implicit wait de yeterli sure oldugundan emin oluruz.
        O sureyi arttirabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gorucez).

        3.Iframe     Cozum => switch to iframe

        4.Alert      Cozum => switch to alert

        5.New window Cozum => switch to window

        *Bunlarin hepsi test case'imizin kalmasi icin sebep olabilir.



     */
}
