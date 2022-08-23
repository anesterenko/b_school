import java.util.*;

public class Stack<T>
{
    private int count = 0;
    private final LinkedList<T> list;

    public Stack()
    {
        list = new LinkedList<>();
    }

    public int size()
    {
        return count;
    }

    public T pop()
    {
        if (count > 0) {
            count--;
            return list.pollLast();
        }
        return null;
    }

    public void push(T val)
    {
       list.addLast(val);
       count++;
    }

    public T peek()
    {
        return list.peekLast();
    }
}