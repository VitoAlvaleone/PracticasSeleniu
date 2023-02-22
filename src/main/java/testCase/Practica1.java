package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.security.auth.login.Configuration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Practica1 {
    private WebDriver driver;
    private String baseUrl;

    @Before

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl ="https://www.google.es/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testCase(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @After
    public void fin(){
        driver.quit();
    }
}
