import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest
{
    public Queue<Integer> queue;

    @Before
    public void setUp()
    {
        queue = new Queue<>();
    }

    @Test
    public void testDequeue()
    {
        queue.Enqueue(1);
        queue.Enqueue(2);

        Assert.assertEquals(1, (int) queue.Dequeue());
    }

    @Test
    public void testDequeue_emptyQueue()
    {
        Assert.assertNull(queue.Dequeue());
    }

    @Test
    public void testSize_emptyQueue()
    {
        Assert.assertEquals(0, queue.Size());
    }

    @Test
    public void testSize()
    {
        queue.Enqueue(1);
        queue.Enqueue(2);
        Assert.assertEquals(2, queue.Size());
    }

    @Test
    public void testRotate()
    {
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        queue.Rotate(2);
        Assert.assertEquals(3, (int)queue.Dequeue());
    }
}
