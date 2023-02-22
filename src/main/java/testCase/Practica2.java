package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practica2 {
    private WebDriver driver;
    private String baseUrl;

    @Before

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aortegaj\\IdeaProjects\\PracticasSelenium\\src\\main\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl ="http://demoaut.katalon.com/#appointment";

    }
    @Test
    public void testCase(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement element = this.driver.findElement(By.linkText("Make Appointment"));
        element.click();
        WebElement nombreUsuario= driver.findElement(By.xpath("//input[@aria-describedby='demo_username_label']"));
        String username = nombreUsuario.getAttribute("value");
        WebElement contraseñaUsuario = this.driver.findElement(By.xpath("//input[@aria-describedby='demo_password_label']"));
        String userpass = contraseñaUsuario.getAttribute("value");
        WebElement casillaUsuario = this.driver.findElement(By.id("txt-username"));
        WebElement casillaContraseña = this.driver.findElement(By.id("txt-password"));
        casillaUsuario.sendKeys(username);
        casillaContraseña.sendKeys(userpass);
        WebElement botonLog = driver.findElement(By.id("btn-login"));
        botonLog.click();
        WebElement combo = driver.findElement(By.id("combo_facility"));
        Select select = new Select(combo);
        select.selectByIndex(2);
        WebElement check = driver.findElement(By.className("checkbox-inline"));
        if(!check.isSelected()){
            check.click();
        }
        /*WebElement radioButton = driver.findElement(By.id("radio_program_medicaid"));
        radioButton.click();*/
        List<WebElement> radiobutton = driver.findElements(By.name("programs"));
        radiobutton.get(1).click();
        WebElement fecha = driver.findElement(By.id("txt_visit_date"));
        fecha.sendKeys("07/06/2000");
        WebElement boton = driver.findElement(By.id("btn-book-appointment"));
        boton.click();
        WebElement homePage = this.driver.findElement(By.linkText("Go to Homepage"));
        homePage.click();
        WebElement menu = driver.findElement(By.id("menu-toggle"));
        menu.click();
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
    }

    @After
    public void fin(){
        driver.quit();
    }
}
