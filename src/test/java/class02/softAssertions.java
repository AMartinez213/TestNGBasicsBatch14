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
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssertions {

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(groups ="regression")
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
//      if we want use soft assertion we call it from the class SoftAssert by declaring an instance
        SoftAssert soft=new SoftAssert();
//      assertion
        soft.assertEquals(actualErrorMSG,expectedErrorMSG);
        System.out.println("I am here after 1st assertion");
//      check if the webelement error message isDisplayed
        boolean isDisplayed=errorMSG.isDisplayed();
//      assertion
        soft.assertTrue(isDisplayed);
//      assert all the assertion that have been made
        soft.assertAll();

    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}

