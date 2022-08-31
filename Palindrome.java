public class Palindrome
{
    public static boolean isPalindrome(String str)
    {
        Deque<String> deque = new Deque<>();

        for (int i = 0; i < str.length(); i++) {
            deque.addTail(Character.toString(str.charAt(i)));
        }

        while (deque.size() > 1) {
            if (!deque.removeFront().equals(deque.removeTail())) {
                return false;
            }
        }
        return true;
    }
}
