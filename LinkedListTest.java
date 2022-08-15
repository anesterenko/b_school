import java.util.*;

import org.junit.Test;
import org.junit.Assert;

public class LinkedListTest {
    
    @Test
    public void testFindAll_existedValues()
    {
        int[] listValues = {1,2,2,3};
        LinkedList list = getList(listValues);
        
        ArrayList<Node> nodes = list.findAll(2);

        int[] expectedValues = {2, 2};
        checkValues(nodes, expectedValues);
    }

    @Test
    public void testFindAll_notExistedValue()
    {
        int[] listValues = {1,2,2,3};
        LinkedList list = getList(listValues);
        
        ArrayList<Node> nodes = list.findAll(4);

        int[] expectedValues = {};
        checkValues(nodes, expectedValues);
    }

    @Test
    public void testFindAll_emptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        ArrayList<Node> nodes = list.findAll(2);

        int[] expectedValues = {};
        checkValues(nodes, expectedValues);
    }

    @Test
    public void testRemove_existedElement()
    {
        int[] listValues = {1,2,3};
        LinkedList list = getList(listValues);
        
        boolean result = list.remove(2);
        Assert.assertTrue(result);
        
        int[] expectedValues = {1, 3};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 3);
    }

    @Test
    public void testRemove_notExistedElement()
    {
        int[] listValues = {1};
        LinkedList list = getList(listValues);

        boolean result = list.remove(2);
        Assert.assertFalse(result);
        
        int[] expectedValues = {1};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 1);
    }

    @Test
    public void testRemove_listWithSingleElement()
    {
        int[] listValues = {1};
        LinkedList list = getList(listValues);
        
        boolean result = list.remove(1);
        Assert.assertTrue(result);
        
        int[] expectedValues = {};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }

    @Test
    public void testRemove_emptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        boolean result = list.remove(1);
        Assert.assertFalse(result);
        
        int[] expectedValues = {};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }

    @Test
    public void testRemove_fromHead()
    {
        int[] listValues = {1, 2};
        LinkedList list = getList(listValues);

        boolean result = list.remove(1);
        Assert.assertTrue(result);
        
        int[] expectedValues = {2};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 2, 2);       
    }

    @Test
    public void testRemove_fromTail()
    {
        int[] listValues = {1,2};
        LinkedList list = getList(listValues);

        boolean result = list.remove(2);
        Assert.assertTrue(result);
        
        int[] expectedValues = {1};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 1);
    }

    @Test
    public void testRemoveAll_existedElements()
    {
        int[] listValues = {1,2,2,3};
        LinkedList list = getList(listValues);
        
        list.removeAll(2);
        
        int[] expectedValues = {1,3};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 3);
    }

    @Test
    public void testRemoveAll_notExistedElements()
    {
        int[] listValues = {1,2,2,3};
        LinkedList list = getList(listValues);
        
        list.removeAll(4);
        
        int[] expectedValues = {1,2,2,3};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 3);
    }

    @Test
    public void testRemoveAll_listWithSingleElement()
    {
        int[] listValues = {1};
        LinkedList list = getList(listValues);
        
        list.removeAll(1);
        
        int[] expectedValues = {};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }

    @Test
    public void testRemoveAll_fromHead()
    {
        int[] listValues = {1,1,2,3};
        LinkedList list = getList(listValues);
        
        list.removeAll(1);
        
        int[] expectedValues = {2,3};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 2, 3);       
    }
    
    @Test
    public void testRemoveAll_fromTail()
    {
        int[] listValues = {1,2,3,3};
        LinkedList list = getList(listValues);
        
        list.removeAll(3);
        
        int[] expectedValues = {1,2};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 2);
    }
    
    @Test
    public void testRemoveAll_fromHeadAndTail()
    {
        int[] listValues = {1,2,3,1};
        LinkedList list = getList(listValues);
        
        list.removeAll(1);
        
        int[] expectedValues = {2,3};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 2, 3);
    }
    
    @Test
    public void testRemoveAll_emptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        list.removeAll(1);
        
        int[] expectedValues = {};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }
    
    @Test
    public void testClear_notEmptyList()
    {
        int[] listValues = {1,2,3};
        LinkedList list = getList(listValues);
        
        list.clear();
        
        int[] expectedValues = {};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }
    
    @Test
    public void testClear_emptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        list.clear();
        
        int[] expectedValues = {};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }
    
    @Test
    public void testCount_notEmptyList()
    {
        int[] listValues = {1,2,3};
        LinkedList list = getList(listValues);
        
        int result = list.count();
        Assert.assertEquals(listValues.length, result);
    }
    
    @Test
    public void testCount_emptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        int result = list.count();
        Assert.assertEquals(0, result);
    }
    
    @Test
    public void testInsertAfter_emptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        list.insertAfter(null, new Node(1));
        
        int[] expectedValues = {1};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 1);
    }
    
    @Test
    public void testInsertAfter_notEmptyList()
    {
        Node first = new Node(1);
        Node second = new Node(2);
        LinkedList list = new LinkedList();
        
        list.addInTail(first);
        list.addInTail(second);
        
        list.insertAfter(first, new Node(3));
        
        int[] expectedValues = {1,3,2};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 2);
    }
    
    @Test
    public void testInsertAfter_head()
    {
        int[] listValues = {1,2};
        LinkedList list = getList(listValues);
        
        list.insertAfter(null, new Node(3));
        
        int[] expectedValues = {3,1,2};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 3, 2);
    }
    
    @Test
    public void testInsertAfter_tail()
    {
        Node first = new Node(1);
        Node second = new Node(2);
        LinkedList list = new LinkedList();
        
        list.addInTail(first);
        list.addInTail(second);
        
        list.insertAfter(second, new Node(3));
        
        int[] expectedValues = {1,2,3};
        checkValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 3);
    }

    private LinkedList getList(int[] values)
    {
        LinkedList list = new LinkedList();
        for (int value: values) {
            list.addInTail(new Node(value));
        }

        return list;
    }

    private void checkValues(LinkedList list, int[] expectedValues)
    {
        int expectedLength = expectedValues.length;
        Node node = list.head;
        int counter = 0;

        while (node != null && counter < expectedLength) {
            checkNodeValue(node, expectedValues[counter]);
            counter++;
            node = node.next;
        }
        Assert.assertTrue(node == null && counter == expectedLength);
    }

    private void checkValues(ArrayList<Node> nodes, int[] expectedValues)
    {
        int expectedLength = expectedValues.length;
        int actualLength = nodes.size();

        Assert.assertEquals(expectedLength, actualLength);

        int counter = 0;
        for (Node node: nodes) {
            checkNodeValue(node, expectedValues[counter]);
            counter++;
        }
    }

    private void checkNodeValue(Node node, Integer expectedValue)
    {
        if (expectedValue != null) {
            Assert.assertTrue(node != null && node.value == expectedValue);
        } else {
            Assert.assertNull(node);
        }
    }

    private void checkTailAndHeadValues(LinkedList list, Integer expectedHeadValue, Integer expectedTailValue)
    {
        checkNodeValue(list.head, expectedHeadValue);
        checkNodeValue(list.tail, expectedTailValue);
    }
}