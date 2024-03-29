package day15_ExtentReport_WebTables;

public class ExtentReportsInterviewSorular {
    //Raporlaramalari nasıl yaparsın?
    //Manual testing yaparken elle ekran goruntusu alip work documanina eklerim. Sonra bu raporları JIRA ya user storye yüklerim
    //Otomasyonda ise Extent Reports ile html raporlarını cikartip
    //Extent Reports raporlari değiştirilebilir, özel proje bilgiler eklenebilir raporlardır
    //Projemde ki raporlama sistemi, test case fail ettiginde otomatik olarak ekran goruntusunu alacak sekilde ayarladim
    //Extent Reports kullanmanın avantajları nelerdir? Neden Extent Reports i tercih ettiniz?
    //Open source- Ücretsiz
    //Farkli browserlar yada islerim sistemleriyle calisabilir
    //Junit, testng, cucumber gibi farklı test otomasyon frameworkleriyle entegre olabilir
    //Her bir test adimini log(rapora yazdirma) yapabiliriz
    //Customizable-Editlenebilir
    //Extent reports ile raporlama islemi nasil gerceklesir? Bilgi verirmisiniz?
    //Oncelikle maven projeleri icin Extent reports dependency oluşturmamız gerekmektedir
    //Reusable classimda extent reports ile alakalı reusable metotlarım var. Bu metotlar yardımıyla raporlarım oluşuyor.
    //3 onemli class vardır:
    //Extent reports
    //Extent Html Reporter.  ====>>>>>>> are user for generation the reports
    //Extent Tess
    //Bu sınıflar yardımıyla, platform, browser, environment, tester, takim bilgileri gibi özel proje bilgileri ekleyebilirim. Ayrıca extent test objesi kullanarak pass, fail, skip gibi loglamalar yapabilirim.
    //Dependency lerini nerden alıyorsun?
    //Şirkette internal bir repository miz var. Bu repodan ihtiyacım olacak dependencyi alıp kullanırım.
    //Dependency sirket reposunda yoksa ne yapılır?
    //Istedigim dependency icin istekde bulunuyorum. Managerlerin onayından sonra eklenen dependencyleri kullanıyorum.
}
