import org.junit.Assert;
import org.junit.Test;

public class BracesBalanceTest
{

    @Test
    public void testIsBalanced()
    {
        boolean result = BracesBalance.isBalanced("(()(()())())");

        Assert.assertTrue(result);
    }

    @Test
    public void testIsBalanced_notBalancedOpenBrace()
    {
        boolean result = BracesBalance.isBalanced("((()(()())())");

        Assert.assertFalse(result);
    }

    @Test
    public void testIsBalanced_notBalancedClosedBrace()
    {
        boolean result = BracesBalance.isBalanced("())");

        Assert.assertFalse(result);
    }

    @Test
    public void testIsBalanced_emptyString()
    {
        boolean result = BracesBalance.isBalanced("");

        Assert.assertFalse(result);
    }
}
