package tests.firsttests;

import org.junit.Assert;
import org.junit.Test;

public class EvenOddCheckerTest {
    calculatorandothers.EvenOddChecker checker = new calculatorandothers.EvenOddChecker();

    @Test
    public void testEvenNumber() {
        Assert.assertTrue(checker.check(2));
    }

    @Test
    public void testOddNumber() {
        Assert.assertFalse(checker.check(3));
    }

    @Test
    public void testZero() {
        Assert.assertTrue(checker.check(0));
    }

    @Test
    public void testNegativeEvenNumber() {
        Assert.assertTrue(checker.check(-2));
    }

    @Test
    public void testNegativeOddNumber() {
        Assert.assertFalse(checker.check(-1));
    }
}
