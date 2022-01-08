package class02;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void login(){
       System.out.println("f");
    }

    @Test(dependsOnMethods = "login")
    public void Dashboard(){
        System.out.println("I'm dashboard test - depended scenario");
    }
}
