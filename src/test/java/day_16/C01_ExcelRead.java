package day_16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class C01_ExcelRead {

    //ADIMLAR
    //Java dosyasina sag tikla ve resources adinda bir klasor olustur
    //Excel dosyasini bu klasore at
    //Resources doyasi excel,word,text,.. gibi data dosyalarinin oldugu klasor adidir.
    @Test
    public void readExcelTest() throws Exception {
        //WORKBOOK(EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) > ROW (SATIR) > CELL (VERI HUCRESI)
        String path = "./src/test/java/resources/Capitals.xlsx";// =>  ./ hepsi, tamami demek.

        //DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCEL DOSYASINI AC / WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //SAYFAYI AC / Sheet1
        //Sheet sheet1 = workbook.getSheetAt(0);//index 0 dan baslar. Ilk sayfayi ac.
        Sheet sheet1 = workbook.getSheet("Sheet1");//Sheet1 isimli sayfayi ac.

        //ILK SATIRA GIDELIM / ROW
        Row row1 = sheet1.getRow(0);//ILK SATIRA GIT

        //ILK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);//ILK HUCREDEKI DATAYI VER

        //O VERIYI YAZDIR
        System.out.println(cell1);

        //1. SATIR 2. SUTUN
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

        //3. SATIR 1. SUTUN
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

        //EXCELDEKI TOPLAM KULLANILAN SATIR SAYISINI BUL
        int toplamSatirSayisi = sheet1.getLastRowNum()+1;//SON SATIR NUMARASI
        System.out.println(toplamSatirSayisi);//11 //index 0 dan basladigi icin +1 ile 11 i bulduk.

        //KULLANILAN TOPLAM SATIR SAYISINI BUL
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi);//1 den baslar //11

        //country, capitals key ve valuelari map e alip print et
        //{{USA,D.C}}, {FRANCE,PARIS},...}

        //Variable olusturalim. Bu variable exceldeki country, capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();

        for (int satirSayisi =1; satirSayisi<kullanilanToplamSatirSayisi;satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
            //ulkeBaskentleri.put(sheet1.getRow(satirSayisi).getCell(0).toString(),sheet1.getRow(satirSayisi).getCell(1).toString());
        }
        System.out.println(ulkeBaskentleri);

//        Map<Cell,Cell> kv = new HashMap<>();
//        IntStream.range(1,toplamSatirSayisi).forEach(t->kv.put(workbook.getSheet("Sheet1").getRow(t).getCell(0),workbook.getSheet("Sheet1").getRow(t).getCell(1)));
//        System.out.println(kv);






    }
}
