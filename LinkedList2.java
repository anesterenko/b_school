import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
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
        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value != _value) {
                node = node.next;
                continue;
            }
            removeNode(node);
            return true;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value != _value) {
                node = node.next;
                continue;
            }
            removeNode(node);
            node = node.next;
        }
    }

    private void removeNode(Node node)
    {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            if (node.next != null) {
                node.next.prev = null;
            }
            this.head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            if (node.prev != null) {
                node.prev.next = null;
            }
            this.tail = node.prev;
        }
    }

    public void clear()
    {
        Node node = this.head;
        Node nextNode;
        while (node != null) {
            nextNode = node.next;
            node.prev = null;
            node.next = null;
            node = nextNode;
        }
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int counter = 0;
        if (this.head != null) {
            Node node = this.head;
            while (node != null) {
                counter++;
                node = node.next;
            }
        }
        return counter;
    }

    public void addInHead(Node node)
    {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }

        this.head.prev = node;
        node.next = this.head;
        this.head = node;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            addInHead(_nodeToInsert);
            return;
        }
        if (_nodeAfter.next == null) {
            this.tail = _nodeToInsert;
        } else {
            _nodeAfter.next.prev = _nodeToInsert;
        }

        _nodeToInsert.next = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeToInsert.prev = _nodeAfter;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}