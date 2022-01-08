package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertion {
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
    public void verifyAndValidationSoftAssertion() {
        SoftAssert soft=new SoftAssert();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Human Manageement System";
        soft.assertEquals(actualTitle, expectedTitle);

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

        WebElement welcomText=driver.findElement(By.xpath("//*[text()='Welcome Admin']"));
        soft.assertTrue(welcomText.isDisplayed());
        System.out.println("Still execute");

        soft.assertAll(); // should be last line of test case
    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
