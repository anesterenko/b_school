import java.util.*;

public class Deque<T>
{
    private final LinkedList<T> queue;
    private int count;

    public Deque()
    {
        queue = new LinkedList<>();
        count = 0;
    }

    public void addFront(T item)
    {
        queue.addFirst(item);
        count++;
    }

    public void addTail(T item)
    {
        queue.addLast(item);
        count++;
    }

    public T removeFront()
    {
        if (count == 0) {
            return null;
        }
        count--;
        return queue.pollFirst();
    }

    public T removeTail()
    {
        if (count == 0) {
            return null;
        }
        count--;
        return queue.pollLast();
    }

    public int size()
    {
        return count; // размер очереди
    }
}