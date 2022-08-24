public class BracesBalance {

    public static boolean isBalanced(String str)
    {
        Stack<String> stack = new Stack<>();
        if (str.length() < 2) {
            return false;
        }

        for (int i = 0; i < str.length(); i++)
        {
            String currentSymbol = Character.toString(str.charAt(i));
            if (currentSymbol.equals("(")) {
                stack.push(currentSymbol);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

}
