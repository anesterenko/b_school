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

    public void Enqueue(T item)
    {
        queue.addLast(item);
        count++;
    }

    public T Dequeue()
    {
        if (count == 0) {
            return null;
        }
        count--;
        return queue.pollFirst();
    }

    public int Size()
    {
        return count;
    }

    public void Rotate(int n)
    {
        int i = n;
        while (i > 0) {
            Enqueue(Dequeue());
            i--;
        }
    }
}
