import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest
{


    @Test
    public void testPalindrome_positive()
    {
        Assert.assertTrue(Palindrome.isPalindrome("arozaupalanalapuazora"));
        Assert.assertTrue(Palindrome.isPalindrome(""));
        Assert.assertTrue(Palindrome.isPalindrome("1"));
        Assert.assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    public void testPalindrome_negative()
    {
        Assert.assertFalse(Palindrome.isPalindrome("arozapalanalapuazora"));
    }
}
