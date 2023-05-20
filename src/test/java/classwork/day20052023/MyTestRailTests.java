package classwork.day20052023;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

public class MyTestRailTests extends RunListener {

    @Test
    @TestCaseId(id = "156385")
    public void testOne() {
        Assert.assertTrue(true);
    }

    @Test
    @TestCaseId(id = "156387")
    public void testTwo() {
        Assert.assertTrue(true);
    }

    @Test
    @TestCaseId(id = "156389")
    public void testThree() {
        Assert.assertTrue(true);
    }

    @Test
    @TestCaseId(id = "156390")
    public void testFour() {
        Assert.assertTrue(false);
    }
}

