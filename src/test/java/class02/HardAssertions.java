package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HardAssertions {

    WebDriver driver;
    @BeforeMethod(alwaysRun=true)
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(groups="regression")
    public void invalidCredentials(){
//      username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
//      password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123@@@@");
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
//      invalid credentials
        WebElement errorMSG = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String actualErrorMSG = errorMSG.getText();
        String expectedErrorMSG = "Invalid credentials";
        /*System.out.println(actualError);
        if(actualError.equalsIgnoreCase(expectedErrorMSG)){
            System.out.println("The error message is there");
        }else{
            System.out.println("The error message is not there");
        }*/
//      assertion

        Assert.assertEquals(actualErrorMSG,expectedErrorMSG);
//      confirm that the error message is displayed
        boolean isDisplayed = errorMSG.isDisplayed();
        Assert.assertTrue(isDisplayed);
    }
    @AfterMethod(alwaysRun=true)
    public void closeBrowser(){
        driver.quit();
    }

}
