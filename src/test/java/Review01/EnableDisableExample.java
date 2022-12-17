package Review01;

import org.testng.annotations.Test;

public class EnableDisableExample {
    @Test(enabled = false)
    public void testOne(){
        System.out.println("My first test");
    }
    @Test
    public void secondTest(){
        System.out.println("My second test");
    }


}
