package day14_Screenshot_ExtentReports;

public class C04_GorduklerimizinGenelTekrari {
    //Ekran goruntusu alma:
    //getScreenShotAs metotu ile alinir. Bu metot Selenium dan gelir
    //getScreenshotAs metotu TakesScreenshot api indan gelir
    //Selenium 4 den itibaren 2 farklı sekilde ekran goruntusu alınabilir: Tum Sayfa, Özel element
    //Olusturmus oldugumuz ReusableMetot yardimizya ister tum sayfanin, istersem belirli bir elementin ekran goruntusunu kolaylıkla alabilirim
    //Extent Reports :
    //Otomasyon raporları almak icin kullanılır.
    //Extent report ayrı bir API dir. Extent reports seleniumin disindada kullanilabirlar.  Bu API dan gelen metotlar yardımıyla rapor sablonu oluşturabilir.
    //3 class kullandık
    //ExtentReports -> sablonu olusturu
    //ExtentHTMLReporter -> sablonu projeye ekler
    //ExtentTest -> raporlama islemini yapar. Loglari rapora yazdırir.
}
