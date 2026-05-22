package Listeners_Code;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Test_cases {

    @Test
    public void Method1() {

        System.out.println("Pass test executed");
    }

    @Test
    public void Method2() {

        System.out.println("Fail test executed");

        Assert.fail();
    }

    @Test
    public void Method3() {

        System.out.println("Skip test executed");

        throw new SkipException("Skipping the test");
    }
}