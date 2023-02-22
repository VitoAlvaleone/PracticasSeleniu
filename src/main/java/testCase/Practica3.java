package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.Amazon;

import java.util.concurrent.TimeUnit;

public class Practica3 {
    Amazon a = new Amazon();
    @Before

    public void setUp(){

        a.busquedaAmazon();
    }
    @Test
    public void testCase(){

    }

    @After
    public void fin(){
    }
}
