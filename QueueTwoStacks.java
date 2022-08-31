public class QueueTwoStacks<T>
{
    private final Stack<T> stack;

    private final Stack<T> tmpStack;

    public QueueTwoStacks()
    {
        stack = new Stack<>();
        tmpStack = new Stack<>();
    }

    public void enqueue(T item)
    {
        stack.push(item);
    }

    public T dequeue()
    {
        if (stack.size() == 0) {
            return null;
        }

        while (stack.size() != 0) {
            tmpStack.push(stack.pop());
        }

        T head = tmpStack.pop();
        while (tmpStack.size() != 0) {
            stack.push(tmpStack.pop());
        }
        return head;
    }

    public int size()
    {
        return stack.size();
    }
}
