package CalendariosSitios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AirbnbTest {

    String URL = "https://www.airbnb.com";
    public WebDriver driver;

    @BeforeMethod

    public void setup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Imagemaker\\IdeaProjects\\CursoSelenium\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get(URL);
}
    @Test 
    public void airbnbTest()  {
        WebDriverWait wait = new WebDriverWait(driver,3);

        driver.findElement(By.xpath("//*[@placeholder='¿A dónde vas?']")).sendKeys("Budapest");
        driver.findElement(By.xpath("//*[@data-testid='accept-btn']")).click();

        //driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-0']")).click();

        WebElement calendario= driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-0']/div/div"));
        calendario.click();

        WebElement fechaIda = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-05-21']"));
        fechaIda.click();

        WebElement fechaRetorno = driver.findElement(By.xpath("//*[@data-testid='datepicker-day-2021-05-28']"));
        fechaRetorno.click();

        WebElement huespedes = driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']/div/div"));
        huespedes.click();


        WebElement cantidadAdultos = driver.findElement(By.xpath("//*[@data-testid='stepper-adults-increase-button']"));
        cantidadAdultos.click();
        cantidadAdultos.click();


        WebElement cantidadNiños = driver.findElement(By.xpath("//*[@data-testid='stepper-children-increase-button']"));
        cantidadNiños.click();

        WebElement cantidadBebes =driver.findElement(By.xpath("//*[@data-testid='stepper-infants-increase-button']"));
        cantidadBebes.click();

        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-search-button']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("Budapest"));

    }

}
