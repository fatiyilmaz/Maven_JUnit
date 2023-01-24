package day15_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReports2 extends TestBase {
    //HATIRLAMAMIZ GEREKEN 3 CLASS
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    @BeforeClass
    public static void extentReportsSetUp(){
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();


        //*******************************RAPORU CUSTOMIZE EDEBILIRIZ*********************************
        //Tek seferlik yaptigimiz islerden birisi, sirkete girdikten sonra bir kez yapariz ne zaman istersek test ederiz.
        //Sablon hazirliyoruz;
        extentReports.setSystemInfo("Test Environment","Regression");//ortam - test
        extentReports.setSystemInfo("Application","Techpro Education");//app - adi
        extentReports.setSystemInfo("Browser","Chrome");//driver
        extentReports.setSystemInfo("Takim","Eagles");//Takim - adi
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");//Buyuk modul
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");//sprint - numara
        extentReports.setSystemInfo("QA","Fatih");//Tester - adi


        //******************************EXTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBILIRIZ****************
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");//dokuman ismi
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");//regression test

        //******************************RAPOR AYARLARI BITTI*******************************************
        //Raporu projeme ekliyorum
        extentReports.attachReporter(extentHtmlReporter);//attach => ekle demek

        //Extent Test objesini olusturmus olduk
        extentTest = extentReports.createTest("Extent Report Login Test","Smoke Test Raporu");

    }

    @Test
    public void extentReportsTest() {
        extentTest.pass("PASS");
        extentTest.info("BILGILENDIRME NOTU");
        extentTest.fail("FAILED");
        extentTest.warning("UYARI MESAjI");
        extentTest.skip("ATLAMA MESAJI");
        extentTest.fatal("COKUS HATASI");

    }
    @AfterClass
    public static void extentReportsTearDown(){
        extentReports.flush();
    }

}
