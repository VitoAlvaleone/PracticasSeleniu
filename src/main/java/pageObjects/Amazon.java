package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Amazon {
    private WebDriver driver;
    private String baseUrl;
    public void busquedaAmazon (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl ="https://www.amazon.es/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement barraBusqueda = driver.findElement(By.id("twotabsearchtextbox"));

    }
}
