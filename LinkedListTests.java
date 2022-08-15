import java.util.*;

class LinkedListTests {
    
    public static void testFindAll()
    {
        checkFindAllExistedValues();
        checkFindAllNotExistedValue();
        checkFindAllInEmptyList();
    }
    
    public static void testRemove() 
    {
        checkRemoveExistedElement();
        checkRemoveNotExistedElement();
        checkRemoveFromListWithSingleElement();
        checkRemoveFromEmptyList();
        checkRemoveElementFromHead();
        checkRemoveElementFromTail();
    }
    
    public static void testRemoveAll()
    {
        checkRemoveAllExistedElements();
        checkRemoveAllNotExistedElements();
        checkRemoveAllFromListWithSingleElement();
        checkRemoveAllFromEmptyList();
        checkRemoveAllElementsFromHead();
        checkRemoveAllElementsFromTail();
        checkRemoveAllElementsFromHeadAndTail();
    }
    
    public static void testClear()
    {
        checkClearNotEmptyList();
        checkClearEmptyList();
    }
    
    public static void testCount()
    {
        checkCountNotEmptyList();
        checkCountEmptyList();
    }
    
    public static void testInsertAfter()
    {
        checkInsertIntoEmptyList();
        checkInsertIntoNotEmptyList();
        checkInsertIntoHead();
        checkInsertIntoTail();
    }

    private static LinkedList getList(int[] values)
    {
        LinkedList list = new LinkedList();
        for (int value: values) {
            list.addInTail(new Node(value));
        }

        return list;
    }
    
    private static void checkListValues(LinkedList list, int[] expectedValues)
    {
        int expectedLength = expectedValues.length;
        Node node = list.head;
        int counter = 0;
        
        while (node != null && counter < expectedLength) {
            checkNodeValue(node, expectedValues[counter]);
            counter++;
            node = node.next;
        }
        assert node == null && counter == expectedLength : "Expected and actual lists have different sizes";
    }

    private static void checkListValues(ArrayList<Node> nodes, int[] expectedValues)
    {
        int expectedLength = expectedValues.length;
        int actualLength = nodes.size();
        
        assert expectedLength == actualLength : "Expected and actual lists have different sizes";

        int counter = 0;
        for (Node node: nodes) {
            checkNodeValue(node, expectedValues[counter]);
            counter++;
        }
    }
    
    private static void checkNodeValue(Node node, Integer expectedValue)
    {
        if (expectedValue != null) {
            assert node != null && node.value == expectedValue : "Unexpected node value";
        } else {
            assert node == null : "Node is not null";
        }    
    }
    
    private static void checkTailAndHeadValues(LinkedList list, Integer headValue, Integer tailValue)
    {
        checkNodeValue(list.head, headValue);
        checkNodeValue(list.tail, tailValue);
    }

    private static void checkFindAllExistedValues()
    {
        int[] listValues = {1,2,2,3};
        LinkedList list = getList(listValues);
        
        ArrayList<Node> nodes = list.findAll(2);

        int[] expectedValues = {2, 2};
        checkListValues(nodes, expectedValues);
    }

    private static void checkFindAllNotExistedValue()
    {
        int[] listValues = {1,2,2,3};
        LinkedList list = getList(listValues);
        
        ArrayList<Node> nodes = list.findAll(4);

        int[] expectedValues = {};
        checkListValues(nodes, expectedValues);
    }

    private static void checkFindAllInEmptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        ArrayList<Node> nodes = list.findAll(2);

        int[] expectedValues = {};
        checkListValues(nodes, expectedValues);
    }

    private static void checkRemoveExistedElement()
    {
        int[] listValues = {1,2,3};
        LinkedList list = getList(listValues);
        
        boolean result = list.remove(2);
        assert result == true : "Unexpected return value";
        
        int[] expectedValues = {1, 3};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 3);
    }

    private static void checkRemoveNotExistedElement()
    {
        int[] listValues = {1};
        LinkedList list = getList(listValues);

        boolean result = list.remove(2);
        assert result == false : "Unexpected return value";
        
        int[] expectedValues = {1};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 1);
    }

    private static void checkRemoveFromListWithSingleElement() 
    {
        int[] listValues = {1};
        LinkedList list = getList(listValues);
        
        boolean result = list.remove(1);
        assert result == true : "Unexpected return value";
        
        int[] expectedValues = {};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }
    
    private static void checkRemoveFromEmptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        boolean result = list.remove(1);
        assert result == false : "Unexpected return value";
        
        int[] expectedValues = {};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }

    private static void checkRemoveElementFromHead() 
    {
        int[] listValues = {1, 2};
        LinkedList list = getList(listValues);

        boolean result = list.remove(1);
        assert result == true : "Unexpected return value";
        
        int[] expectedValues = {2};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 2, 2);       
    }

    private static void checkRemoveElementFromTail() 
    {
        int[] listValues = {1,2};
        LinkedList list = getList(listValues);

        boolean result = list.remove(2);
        assert result == true : "Unexpected return value";
        
        int[] expectedValues = {1};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 1);
    }
    
    private static void checkRemoveAllExistedElements()
    {
        int[] listValues = {1,2,2,3};
        LinkedList list = getList(listValues);
        
        list.removeAll(2);
        
        int[] expectedValues = {1,3};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 3);
    }
    
    private static void checkRemoveAllNotExistedElements()
    {
        int[] listValues = {1,2,2,3};
        LinkedList list = getList(listValues);
        
        list.removeAll(4);
        
        int[] expectedValues = {1,2,2,3};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 3);
    }
    
    private static void checkRemoveAllFromListWithSingleElement()
    {
        int[] listValues = {1};
        LinkedList list = getList(listValues);
        
        list.removeAll(1);
        
        int[] expectedValues = {};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }
    
    private static void checkRemoveAllElementsFromHead()
    {
        int[] listValues = {1,1,2,3};
        LinkedList list = getList(listValues);
        
        list.removeAll(1);
        
        int[] expectedValues = {2,3};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 2, 3);       
    }
    
    private static void checkRemoveAllElementsFromTail()
    {
        int[] listValues = {1,2,3,3};
        LinkedList list = getList(listValues);
        
        list.removeAll(3);
        
        int[] expectedValues = {1,2};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 2);
    }
    
    private static void checkRemoveAllElementsFromHeadAndTail()
    {
        int[] listValues = {1,2,3,1};
        LinkedList list = getList(listValues);
        
        list.removeAll(1);
        
        int[] expectedValues = {2,3};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 2, 3);
    }
    
    private static void checkRemoveAllFromEmptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        list.removeAll(1);
        
        int[] expectedValues = {};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }
    
    private static void checkClearNotEmptyList()
    {
        int[] listValues = {1,2,3};
        LinkedList list = getList(listValues);
        
        list.clear();
        
        int[] expectedValues = {};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }
    
    private static void checkClearEmptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        list.clear();
        
        int[] expectedValues = {};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, null, null);
    }
    
    private static void checkCountNotEmptyList()
    {
        int[] listValues = {1,2,3};
        LinkedList list = getList(listValues);
        
        int result = list.count();
        assert result == listValues.length;
    }
    
    private static void checkCountEmptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        int result = list.count();
        assert result == 0;
    }
    
    private static void checkInsertIntoEmptyList()
    {
        int[] listValues = {};
        LinkedList list = getList(listValues);
        
        list.insertAfter(null, new Node(1));
        
        int[] expectedValues = {1};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 1);
    }
    
    private static void checkInsertIntoNotEmptyList()
    {
        Node first = new Node(1);
        Node second = new Node(2);
        LinkedList list = new LinkedList();
        
        list.addInTail(first);
        list.addInTail(second);
        
        list.insertAfter(first, new Node(3));
        
        int[] expectedValues = {1,3,2};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 2);
    }
    
    private static void checkInsertIntoHead()
    {
        int[] listValues = {1,2};
        LinkedList list = getList(listValues);
        
        list.insertAfter(null, new Node(3));
        
        int[] expectedValues = {3,1,2};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 3, 2);
    }
    
    private static void checkInsertIntoTail()
    {
        Node first = new Node(1);
        Node second = new Node(2);
        LinkedList list = new LinkedList();
        
        list.addInTail(first);
        list.addInTail(second);
        
        list.insertAfter(second, new Node(3));
        
        int[] expectedValues = {1,2,3};
        checkListValues(list, expectedValues);
        checkTailAndHeadValues(list, 1, 3);
    }
}