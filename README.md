# DataStuctures

# Singly Linked List

Node contains Key and a next pointer

List of API

1. PushFront(key) Add to the front
2. key TopFront() - return a key from the front
3. PopFront() - remove an item from front
4. PushBack(key) - Add to the end of the list
5. key TopBack() - return from the end of the list
6. PopBack() - remove an item from end
7. Boolean Find(key) - Is the key present
8. Erase(key) - remove a key from list
9. Boolean Empty() - Is the List empty.
10. AddBefore(Node, Key) - To add a key before the node
11. AddAfter(Node, Key) - To add a key after the node

# Node definition with Key and reference to the next Node

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
}

# Algo for PushFront

A reference of head and tail is created

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

# Algo for popFront()
Logic followed is if head is null which means the linkedlist is empty
if head is not empty, 
1. create a new Node and store head in it
2. get the next reference from the new node which is basically the next node
3. store that as head.

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