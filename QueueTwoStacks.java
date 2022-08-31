public class QueueTwoStacks<T>
{
    private final Stack<T> in;

    private final Stack<T> out;

    public QueueTwoStacks()
    {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void enqueue(T item)
    {
        in.push(item);
    }

    public T dequeue()
    {
        if (in.size() == 0) {
            return null;
        }

        if (out.size() == 0) {
            while (in.size() != 0) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int size()
    {
        return in.size();
    }
}
