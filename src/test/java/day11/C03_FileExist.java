package day11;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void isExistTest(){

        //Masa ustunden bir dosyanın varligini test et

        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);// C:\Users\yy890\IdeaProjects\Maven_Junit

        String userHOME = System.getProperty("user.home");
        System.out.println(userHOME);// C:\Users\yy890

        //logo.jpeg indirip MASAUSTUNE kaydedin
        //Logo masaustunde : /Users/techproed/Desktop

        String dosyaYolu = userHOME +"/OneDrive/Masaüstü/logo.jpeg";
//        String dosyaYolu = userHOME +"\\Desktop\\logo.jpeg";
        System.out.println(dosyaYolu);
        boolean isExist = Files.exists(Paths.get(dosyaYolu));//dosya var ise tru, yok ise false
        Assert.assertTrue(isExist);





    }
}
