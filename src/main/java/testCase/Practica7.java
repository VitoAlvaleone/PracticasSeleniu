package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Practica7 {
    private WebDriver driver;
    private String baseUrl;

    @Before

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl ="http://demo.guru99.com/test/guru99home/";
    }

    @Test
    public void testCase() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement idFrame = driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(idFrame);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"save\"]/span[1]/div/span"));
        element.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
        js.executeScript("window.scrollBy(1000,0)");
    }

    @After
    public void fin() {

    }
}
