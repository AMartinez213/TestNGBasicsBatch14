package class01;

import org.testng.annotations.*;

public class testNGAnnotation {

    //    First Test Case
    @Test
    public void firstTestCase() {
        System.out.println("I am the first test case");
    }

    @Test
    public void secondTestCase() {
        System.out.println("I am the second test case");
    }

    @Test
    public void thirdTestCase() {
        System.out.println("I am the third test case");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }
}