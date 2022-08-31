import java.util.*;

public class Deque<T>
{
    private final LinkedList<T> queue;

    public Deque()
    {
        queue = new LinkedList<>();
    }

    public void addFront(T item)
    {
        queue.addFirst(item);
    }

    public void addTail(T item)
    {
        queue.addLast(item);
    }

    public T removeFront()
    {
        if (queue.size() == 0) {
            return null;
        }
        return queue.pollFirst();
    }

    public T removeTail()
    {
        if (queue.size() == 0) {
            return null;
        }
        return queue.pollLast();
    }

    public int size()
    {
        return queue.size();
    }
}
