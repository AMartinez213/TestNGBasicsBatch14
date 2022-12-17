package class01;

import org.testng.annotations.Test;

public class dependsOn {

    @Test
    public void LogIn(){
        System.out.println("Log-In");
    }
    @Test(dependsOnMethods = "LogIn")
    public void DashBoardVerification(){
        System.out.println("after log-in in i am verifying the dashboard page");
    }
}
