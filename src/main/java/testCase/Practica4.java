package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Practica4 {
    private WebDriver driver;
    private String baseUrl;

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.es/";
    }

    @Test
    public void testCase() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[text()='Aceptar todo']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("NttData");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='https://www.nttdata.com/global/en/']")).click();

        WebElement element = driver.findElement(By.id("ensCloseBanner"));
        element.click();
        element = driver.findElement(By.xpath("//img[@alt='Search']"));
        element.click();
        element = driver.findElement(By.id("search-box"));
        element.sendKeys("NTTDATA");
        element = driver.findElement(By.xpath("//button[@class='l-header__search-form__button']"));
        element.click();

        js.executeScript("window.scrollBy(0,1000)");
    }

    @After
    public void fin() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
