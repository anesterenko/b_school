import java.util.LinkedList;

public class Queue<T>
{
    private final LinkedList<T> queue;
    private int count;

    public Queue()
    {
        queue = new LinkedList<>();
        count = 0;
    }

    public void enqueue(T item)
    {
        queue.addLast(item);
        count++;
    }

    public T dequeue()
    {
        if (count == 0) {
            return null;
        }
        count--;
        return queue.pollFirst();
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
