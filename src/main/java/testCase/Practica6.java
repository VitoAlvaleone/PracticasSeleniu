package testCase;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Practica6 {
    private WebDriver driver;
    private String baseUrl;

    @Before

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://demo.guru99.com/test/upload/";
        WebElement idFrame = driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(idFrame);
        WebDriverWait driverWait = new WebDriverWait(driver, 30);
        WebElement cookiesButton = driver.findElement(By.className("action-wrapper"));
        driverWait.until(ExpectedConditions.elementToBeClickable(cookiesButton));

        File scriptFile = (File) ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(scriptFile, new File("C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\java\\imagen\\micaptura.png"));
        } catch (IOException var3) {
            var3.printStackTrace();
        }
    }

    @Test
    public void testCase() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @After
    public void fin() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
}
