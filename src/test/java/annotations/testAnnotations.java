package annotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class testAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I am before suit *_*");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("I am after suit -_-");
    }
    @BeforeTest
    public void BT(){
        System.out.println("I am before test -----------------");
    }
    @AfterTest
    public void AT(){
        System.out.println("I am after test -------------------");
    }
}
