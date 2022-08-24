public class PostfixOperations
{
    interface IntegerMath
    {
        int operation (int x, int y) ;
    }

    private static final IntegerMath addition = Integer::sum;
    private static final IntegerMath multiplication = (x, y) -> x * y;

    public static Integer calculate(String expression)
    {
        Stack<String> stack = new Stack<>();

        String trimmedExpression = expression.trim();
        String[] operandsAndOperators = trimmedExpression.isBlank() ? new String[0] : expression.trim().split("\\s+");

        int i = operandsAndOperators.length - 1;
        while (i >= 0) {
            stack.push(operandsAndOperators[i]);
            i--;
        }
        return calculate(stack);
    }

    public static Integer calculate(Stack<String> expression)
    {
        Stack<Integer> stack = new Stack<>();
        while (expression.size() != 0) {
            String symbol = expression.pop();

            if (isReturnOperation(symbol)) {
                return stack.pop();
            }
            int newValue = isNumber(symbol) ?
                    Integer.parseInt(symbol) :
                    performOperation(symbol, stack);
            stack.push(newValue);
        }
        return null;
    }

    private static boolean isReturnOperation(String symbol)
    {
        return symbol.equals("=");
    }

    private static boolean isNumber(String symbol)
    {
        return symbol.matches("\\d+");
    }

    private static Integer performOperation(String symbol, Stack<Integer> stack)
    {
        int x = stack.pop();
        int y = stack.pop();
        return apply(x, y, getOperation(symbol));
    }

    private static int apply(int x, int y, IntegerMath op)
    {
        return op.operation(x, y);
    }

    private static IntegerMath getOperation(String symbol)
    {
        IntegerMath operation;

        switch (symbol) {
            case "+":
                operation = addition;
                break;
            case "*":
                operation = multiplication;
                break;
            default:
                throw new UnsupportedOperationException(symbol);
        }
        return operation;
    }
}
