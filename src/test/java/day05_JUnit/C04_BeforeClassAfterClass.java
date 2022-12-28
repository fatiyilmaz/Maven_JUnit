package day05_JUnit;

import org.junit.*;


public class C04_BeforeClassAfterClass {

    /*
        @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
        @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test methodlarinin hepsini ayni anda calistirip
        en son @AfterClass'i calistiririz.
        Ama sadece @Before ve @After kullanirsak her test icin @before ve @after'i kullanir.

        @BeforeClass--->Test01, Test02, Test03....-->@AfterClass
        Before--> Test01---> After
        Before--> Test02---> After
     */

    @BeforeClass
    public static void setUp(){
        System.out.println("Butun testlerden once calisti");

    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Butun testlerden sonra calisti");
    }
    @Before
    public void setUp01(){
        System.out.println("Her test'ten once calisir");
    }
    @After
    public void tearDown01(){
        System.out.println("Her test'ten sonra calisir");
    }

    @Test
    public void test01(){
        System.out.println("Ilk Test");
    }

    @Test
    public void test02(){
        System.out.println("Ikinci Test");
    }

    @Test
    @Ignore //Eger bir testi calistirmak istemezsek bu sekilde kullabiliriz.
    public void test03(){
        System.out.println("Ucuncu Test");
    }
}
