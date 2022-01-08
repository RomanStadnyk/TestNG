package class02.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task01 {
    WebDriver driver;

    @BeforeMethod
    public void openBrowserAndLaunchApplication() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void textDisplayed(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("btnLogin")).click();

        String txtExpected="Password cannot be empty";
        String txtActual=driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
        Assert.assertEquals(txtActual, txtExpected);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
