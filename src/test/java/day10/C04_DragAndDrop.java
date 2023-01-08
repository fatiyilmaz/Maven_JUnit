package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {

    //

    @Test
    public void dragAndDrop(){

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);


        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);

        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(kaynak,hedef).perform();// surukleme islemini gercektirdik

    }

    @Test
    public void clickAndHoldTest(){
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);


        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);

        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        actions
                .clickAndHold(kaynak)//Kaynagi tut
                .moveToElement(hedef)//Hedefe koy
                .release()//Kaynagi birak
                .build()//onceki methodlarin iliskisini kur/guclendir. BIRDEN FAZLA FONKSIYONLAR KULLANILIRKEN TERCIH EDILIR.
                .perform();//islemi gerceklestirir.   KULLANILMASI ZORUNLUDUR


    }

    @Test
    public void moveByOffSetTest(){
        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);


        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);

        WebElement kaynak = driver.findElement(By.id("draggable"));
        actions.clickAndHold(kaynak)//Kaynagi tut
                .moveByOffset(430,30)
                .release()//Kaynagi birak
                .build()
                .perform();
    }

}
