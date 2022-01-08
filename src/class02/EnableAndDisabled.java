package class02;

import org.testng.annotations.Test;

public class EnableAndDisabled {

    @Test(enabled = true)
    public void firstTest() {
        System.out.println("I'm first test");
    }

    @Test (enabled = false)
    public void secondTest() {
        System.out.println("I'm second test");
    }

    @Test(enabled = true)
    public void thirdTest() {
        System.out.println("I'm third test");
    }
}
