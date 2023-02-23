package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Practica3 {
    private WebDriver driver;
    private String baseUrl;

    @Before

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.amazon.es/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        WebElement cookies = driver.findElement(By.id("sp-cc-accept"));
        cookies.click();
        WebElement inputSearch = driver.findElement(By.id("twotabsearchtextbox"));
        inputSearch.sendKeys("SSD");
        inputSearch.sendKeys(Keys.ENTER);
        WebElement product = driver.findElement(By.xpath("//div[@id='s-skipLinkTargetForMainSearchResults']/following-sibling::span[@data-component-type='s-search-results']/descendant::div[@class='s-main-slot s-result-list s-search-results sg-row']/child::div[@data-index=2]/descendant::a[@class='a-link-normal s-no-outline']"));
        product.click();
        String price = driver.findElement(By.xpath("//div[@id='corePrice_feature_div']/descendant::span[2]")).getText();
        driver.findElement(By.id("add-to-cart-button")).submit();
        WebElement element = driver.findElement(By.id("nav-cart-count"));
        element.click();
        String precioFinal = driver.findElement(By.xpath("//*[@id=\"sc-subtotal-amount-buybox\"]/span")).getText();
        System.out.println(precioFinal);
    }

    @After
    public void fin() {
    }
}
