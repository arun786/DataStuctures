package SinglyLinkedList;

public class SinglyLinkedList {

    public static void main(String[] args) {

        SinglyLinkedListImpl<String> lst = new SinglyLinkedListImpl<String>();
        lst.pushFront("arun");
        lst.pushFront("adwiti");
        lst.pushFront("sachin");
        lst.pushFront("kavya");

        System.out.println(lst);

        lst.popFront();
        lst.popFront();
        lst.popFront();
        lst.popFront();
        lst.popFront();
    }
}

/**
 * @param <T> Various operations of Singly Linked List
 *            1. PushFront - Adding a new key at the front of a linked list
 */
class SinglyLinkedListImpl<T> {

    Node<T> head;
    Node<T> tail;

    /**
     * @param key This method adds a key in other words value to the single linked list
     */
    public void pushFront(T key) {
        /*step 1 : create a new node*/
        Node<T> newNode = new Node<T>();
        newNode.setKey(key);

       /* Check if head is null, if it is which means list is empty,
        we assign the new node to both head and tail
        else we set the reference of the existing tail to new node
        and then assign the new node to tail*/

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setRefToNextNode(newNode);
            tail = newNode;
        }
    }

    /**
     * This method is to remove an element from front
     */
    public void popFront() {
        if (head == null) {
            System.out.println("List is empty");
        }
        Node<T> temp = head;
        if (temp != null) {
            head = temp.getRefToNextNode();
            if (head == null) {
                tail = null;
            }
            System.out.println("Deleted .. " + temp.getKey());
        }
    }

    @Override
    public String toString() {
        return "SinglyLinkedListImpl{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}

/**
 * @param <T> Singly Linked List will contain Nodes which in turn will
 *            contain Key and reference to the next Node
 */
class Node<T> implements Comparable<T> {

    private Node<T> refToNextNode;
    private T key;

    @Override
    public int compareTo(T o) {
        if (o == this.key)
            return 0;
        else
            return 1;
    }

    public Node<T> getRefToNextNode() {
        return refToNextNode;
    }

    public void setRefToNextNode(Node<T> refToNextNode) {
        this.refToNextNode = refToNextNode;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                '}';
    }
}
