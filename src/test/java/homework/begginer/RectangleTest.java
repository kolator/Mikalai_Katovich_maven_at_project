package homework.begginer;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {
    @Test
    public void testRectangleWidth() {
        calculatorandothers.Rectangle rectangle = new calculatorandothers.Rectangle(3.01, 4);
        Assert.assertEquals(4, rectangle.getWidth(), 0);
    }
    @Test
    public void testRectangleLength() {
        calculatorandothers.Rectangle rectangle = new calculatorandothers.Rectangle(3.01, 4);
        Assert.assertEquals(3.01, rectangle.getLength(), 0);
    }
    @Test
    public void testRectangleArea() {
        calculatorandothers.Rectangle rectangle = new calculatorandothers.Rectangle(3.01, 4);
        Assert.assertEquals(12.04, rectangle.getArea(), 0);
    }
    @Test
    public void testRectangleSetWidth() {
        calculatorandothers.Rectangle rectangle = new calculatorandothers.Rectangle(3.01, 4);
        rectangle.setWidth(5);
        Assert.assertEquals(5, rectangle.getWidth(), 0);
    }
    @Test
    public void testRectangleSetWidthGetArea() {
        calculatorandothers.Rectangle rectangle = new calculatorandothers.Rectangle(3.01, 4);
        rectangle.setWidth(5);
        Assert.assertEquals(15.05, rectangle.getArea(), 0.01); //шо за математика
    }
    @Test
    public void testRectangleSetLength() {
        calculatorandothers.Rectangle rectangle = new calculatorandothers.Rectangle(3.01, 4);
        rectangle.setLength(5);
        Assert.assertEquals(5, rectangle.getLength(), 0);
    }
    @Test
    public void testRectangleSetLengthGetArea() {
        calculatorandothers.Rectangle rectangle = new calculatorandothers.Rectangle(3.01, 4);
        rectangle.setLength(5);
        Assert.assertEquals(15.05, rectangle.getArea(), 0.01); //шо за математика
    }
    @Test
    public void testRectangleSetLengthAndWidthGetArea() {
        calculatorandothers.Rectangle rectangle = new calculatorandothers.Rectangle(3.01,4);
        rectangle.setWidth(5);
        rectangle.setLength(5);
        Assert.assertEquals(25, rectangle.getArea(), 0);
    }
}
