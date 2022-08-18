import java.util.*;

public class LinkedList2Dummy {
    private final DummyNode head;
    private final DummyNode tail;

    public LinkedList2Dummy()
    {
        head = new DummyNode();
        tail = new DummyNode();
        head.next = tail;
        tail.prev = head;
    }

    public void addInHead(Node node)
    {
        this.head.next.prev = node;
        node.next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
    }

    public void addInTail(Node node)
    {
        this.tail.prev.next = node;
        node.prev = this.tail.prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    public Node find(int _value)
    {
        Node node = this.head.next;
        while (isUsualNode(node)) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head.next;

        while (isUsualNode(node)) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head.next;
        while (isUsualNode(node)) {
            if (node.value == _value) {
                removeNode(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head.next;
        while (isUsualNode(node)) {
            if (node.value == _value) {
                removeNode(node);
            }
            node = node.next;
        }
    }

    public int count()
    {
        int counter = 0;
        Node node = this.head.next;
        while (isUsualNode(node)) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    public void clear()
    {
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            addInHead(_nodeToInsert);
            return;
        }
        _nodeAfter.next.prev = _nodeToInsert;
        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.prev = _nodeAfter;
    }
    private void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private boolean isUsualNode(Node node)
    {
        return !(node instanceof DummyNode);
    }
}

class Node
{
    public final int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

class DummyNode extends Node
{
    public DummyNode()
    {
        super(0);
    }
}