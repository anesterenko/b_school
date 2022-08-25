import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTwoStacksTest
{
    public QueueTwoStacks<Integer> queue;

    @Before
    public void setUp()
    {
        queue = new QueueTwoStacks<>();
    }

    @Test
    public void testDequeue()
    {
        queue.enqueue(1);
        queue.enqueue(2);

        Assert.assertEquals(1, (int) queue.dequeue());
    }

    @Test
    public void testDequeue_emptyQueue()
    {
        Assert.assertNull(queue.dequeue());
    }

    @Test
    public void testSize_emptyQueue()
    {
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void testSize()
    {
        queue.enqueue(1);
        queue.enqueue(2);
        Assert.assertEquals(2, queue.size());
    }

    @Test
    public void testRotate()
    {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.rotate(2);
        Assert.assertEquals(3, (int)queue.dequeue());
    }
}
