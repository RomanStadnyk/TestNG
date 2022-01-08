package class01;

import org.testng.annotations.*;

public class BeforeClassAndAfterClass {

    @BeforeClass
    public void beforeClass(){
        System.out.println("I'm before class ");
        System.out.println();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I'm after class ");
        System.out.println();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I'm before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I'm after method");
        System.out.println();
    }

    @Test
    public void thirdTest(){
        System.out.println("I'm third test");
    }

    @Test
    public void secondTest(){
        System.out.println("I'm second test");
    }

    @Test
    public void firstTest(){
        System.out.println("I'm first test");
    }
}
