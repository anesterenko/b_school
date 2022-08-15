import java.util.*;

class LinkedListsSum {

    public static LinkedList sum(LinkedList first, LinkedList second)
    {
        if (first.count() != second.count()) {
            return null;
        }
        
        LinkedList sum = new LinkedList();
        
        Node nodeFirst = first.head;
        Node nodeSecond = second.head;
        
        while(nodeFirst != null) {
            Node sumNode = new Node(nodeFirst.value + nodeSecond.value);
            sum.addInTail(sumNode);
            nodeFirst = nodeFirst.next;
            nodeSecond = nodeSecond.next;
        }
        
        return sum;
    }
}
