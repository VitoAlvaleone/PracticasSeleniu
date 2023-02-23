package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Practica5 {
    private WebDriver driver;
    private String baseUrl;

    @Before

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl ="https://demo.guru99.com/test/delete_customer.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testCase(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("submit"));
        element.click();
        String contenidoAlert1 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        String contenidoAlert2 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(contenidoAlert1);
        System.out.println(contenidoAlert2);
    }

    @After
    public void fin() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
