public class QueueTwoStacks<T>
{
    private final Stack<T> stack;

    private final Stack<T> tmpStack;

    private int count;

    public QueueTwoStacks()
    {
        stack = new Stack<>();
        tmpStack = new Stack<>();
        count = 0;
    }

    public void enqueue(T item)
    {
        stack.push(item);
        count++;
    }

    public T dequeue()
    {
        if (count == 0) {
            return null;
        }

        while (stack.size() != 0) {
            tmpStack.push(stack.pop());
        }

        T first = tmpStack.pop();
        while (tmpStack.size() != 0) {
            stack.push(tmpStack.pop());
        }
        count--;
        return first;
    }

    public int size()
    {
        return count;
    }

    public void rotate(int n)
    {
        int i = n;
        while (i > 0) {
            enqueue(dequeue());
            i--;
        }
    }
}
