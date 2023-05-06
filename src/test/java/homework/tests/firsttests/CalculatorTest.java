package homework.tests.firsttests;

import org.junit.Assert;
import org.junit.Test;
import calculatorandothers.Calculator;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void calculatorTestAdd() {
        Assert.assertEquals("Addition returned wrong result", 4, calculator.add(2, 2));
    }

    @Test
    public void calculatorTestSubtract() {
        Assert.assertEquals("Subtract returned wrong result", 0, calculator.subtract(2, 2));
    }

    @Test
    public void calculatorTestMultiply() {
        Assert.assertEquals("Multiply returned wrong result", 4, calculator.multiply(2, 2));
    }

    @Test
    public void calculatorTestDivide() {
        Assert.assertEquals("Divide returned wrong result", 1, calculator.divide(2, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void calculatorNegativeTestDivide() {
        calculator.divide(2, 0);
    }
}