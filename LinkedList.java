import java.util.*;

class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public void addInHead(Node item) {
        if (this.head == null) {
            this.tail = item;
         }

        Node prevHead = this.head;
        this.head = item;
        this.head.next = prevHead;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
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
    Node prevNode = null;
    Node nextNode = null;

    while (node != null) {
        nextNode = node.next;
        
        if (node.value == _value) {
            if (prevNode == null) {
                this.head = nextNode;
                node.next = null;
            } else {
                prevNode.next = nextNode;
            }
            
            if (nextNode == null) {
                this.tail = prevNode;
            }
            return true;
        } else {
            prevNode = node;
            node = nextNode;            
        }
    }
        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        Node prevNode = null;
        Node nextNode = null;
        
        while (node != null) {
            nextNode = node.next;
            if (node.value == _value) {
                if (prevNode == null) {
                    this.head = nextNode;
                } else {
                    prevNode.next = nextNode;
                }
                
                if (nextNode == null) {
                    this.tail = prevNode;
                }
            } else {
                prevNode = node;
            }
            node = nextNode;
        }
    }

    public void clear()
    {
        Node node = this.head;
        Node nextNode = null;
        
        while (node != null) {
            nextNode = node.next;
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

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            this.addInHead(_nodeToInsert);
            return;
        }
        Node oldNext = _nodeAfter.next;
        _nodeAfter.next = _nodeToInsert;
        _nodeAfter.next.next = oldNext;                
    }
}

class Node
{
     public int value;
     public Node next;
     public Node(int _value) 
     {  
       value = _value;
       next = null;
     }
}

