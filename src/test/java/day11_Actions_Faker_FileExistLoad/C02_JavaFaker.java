package day11_Actions_Faker_FileExistLoad;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {


    @Test
    public void javaFakerTest(){

        // 1.ADIM:  FAKER OBJESI OLUSTUR
        Faker faker = new Faker();

        //2.ADIM:   FAKER OBJESI ILE FAKE DATA OLUSTUR
        //first name datasi
        String fName = faker.name().firstName();
        System.out.println(fName);

        //last name datasi
        String lNmae = faker.name().lastName();
        System.out.println(lNmae);

        //kullanici adi
        String username = faker.name().username();
        System.out.println(username);

        //meslek ismi
        System.out.println(faker.name().title());//Meslek ismi

        //sehir
        System.out.println(faker.address().city());

        //eyalet
        System.out.println(faker.address().state());

        //full adress
        System.out.println(faker.address().fullAddress());

        //cep telefon numarasi
        System.out.println(faker.phoneNumber().cellPhone());

        //email
        System.out.println(faker.internet().emailAddress());

        //posta kodu
        System.out.println(faker.address().zipCode());

        //rastgale 15 haneli numara
        System.out.println(faker.number().digits(11));

        /*

            TEST DATA : kullanici adi, sifre, tel no, email, sehir, kredi kart no...

             interview sorusu
            Test datalari kimden alinir?
            1. BA - Business Anaylist
            2. Test Lead
            3. Manuel Tester
            4. Tech Lead & Team Lead & Dev Lead
            5. Developer => uzun sure oradaysa sorulabilir
            6. Database
            7. API call lar
            8. Documantasyonlar. Ognegin, API swagger documani
            9. Java Faker da fake data almak icin kullaniyoruz


            NERDEM GELMEZ : en user - kullanicidan, scrum master(okul muduru yada rehberlikci gibidir).



         */
    }
}
