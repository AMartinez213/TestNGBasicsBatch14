package class01;

import org.testng.annotations.Test;

public class priority {

    @Test(priority = 2,groups = "regression")
    public void aTest(){
        System.out.println("I am A test");
    }
    @Test(priority = 1)
    public void bTest(){
        System.out.println("I am B test");
    }
    @Test(priority = 3)
    public void cTest(){
        System.out.println("I am C test");
    }

    @Test
    public void dTest(){
        System.out.println("I am D test");
    }
    @Test
    public void eTest(){
        System.out.println("I am E test");
    }
}
