import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Integer) {
            return (Integer) v1 - (Integer) v2;
        }

        if (v1 instanceof String) {
            return ((String) v1).trim().compareTo((String) v2);
        }
        return 0;
    }

    public void add(T value)
    {
        if (this.head == null) {
            addInHead(value);
            return;
        }

        Node<T> node = this.head;
        while (node != null) {
            if (this._ascending == (compare(node.value, value) >= 0)) {
                Node<T> newNode = new Node<>(value);
                newNode.prev = node.prev;
                node.prev = newNode;
                newNode.next = node;

                if (newNode.prev == null) {
                    this.head = newNode;
                } else {
                    newNode.prev.next = newNode;
                }
                return;
            }
            node = node.next;
        }

        addInTail(value);
    }

    public Node<T> find(T val)
    {
        Node<T> node = this.head;
        while (node != null) {
            if (compare(node.value, val) == 0) {
                return node;
            }

            if (this._ascending == (compare(node.value, val) > 0)) {
                return null;
            }
            node = node.next;
        }
        return null;
    }

    public void removeNode(Node<T> node)
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

    public void delete(T val)
    {
        Node<T> node = this.head;
        while (node != null) {
            if (compare(node.value, val) == 0) {
                removeNode(node);
                return;
            }
            node = node.next;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        Node<T> node = this.head;
        Node<T> nextNode;
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
        Node<T> node = this.head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    private void addInHead(T value)
    {
        Node<T> node = new Node<>(value);
        this.head = node;
        this.tail = node;
    }

    private void addInTail(T value)
    {
        Node<T> newNode = new Node<>(value);
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}