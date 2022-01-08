package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Priority {
    WebDriver driver;
    @BeforeMethod
    public void openBrowserAndLaunchApplication(){
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //@Test -- perform login
    @Test(priority = 2)
    public void adminLogin(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

    }

    @Test(priority = 1)
    public void validationOfTitle(){
        String actualTitle=driver.getTitle();
        String expectedTitle="Human Management System";
        if(expectedTitle.equals(actualTitle)){
            System.out.println("test is passed");
        } else {
            System.out.println("test is failed");
        }
    }

    //post condition @afterMethod -- close browser
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
