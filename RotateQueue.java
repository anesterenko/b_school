public class RotateQueue
{
    public static <T> void rotate(Queue<T> q, int n)
    {
        int i = n;
        while (i > 0) {
            q.enqueue(q.dequeue());
            i--;
        }
    }
}
