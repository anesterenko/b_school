import org.junit.Assert;
import org.junit.Test;

public class PostfixOperationsTest
{
    @Test
    public void testCalculate()
    {
        Integer result = PostfixOperations.calculate("8 2 + 5 * 9 + = ");
        Assert.assertEquals(59, (int)result);
    }

    @Test
    public void testCalculate_emptyExpression()
    {
        Integer result = PostfixOperations.calculate("");

        Assert.assertNull(result);
    }

    @Test
    public void testCalculate_noReturn()
    {
        Integer result = PostfixOperations.calculate("8 2 + 5 * 9 +");

        Assert.assertNull(result);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCalculate_unsupportedOperation()
    {
        PostfixOperations.calculate("8 2 + 5 * 9 / = ");
    }
}
