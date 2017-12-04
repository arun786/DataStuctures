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

# Algo for PopFront
Logic followed is if head is null which means the linked List is empty
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
    
# Algo for PushBack

1. Create a new node.
2. Add the reference of the new node to the tail
3. Make the new node as the tail
4. if the list is empty, add to head too

    
    /**
     * @param key This method adds a new key at the end of the list
     */
     
    public void pushBack(T key) {

        Node<T> newNode = new Node<T>();
        newNode.setKey(key);
        if (tail != null) {
            tail.setRefToNextNode(newNode);
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
    }
    
 # Algo for PopBack
 
 PopBack means removing an item from the end of the linked list
 
 Steps to remove an item from the end of the linked list are as follows
 
 Case 1 : when the linked list is empty. No action to be taken
 Case 2 : When there is only one element in the linked list, make both head and tail as null
 Case 3 : When there are elements in the linked list
 1. Traverse the whole Linked List till the reference to the next node points to tail.
 2. Change the node to tail and make the reference of the node to null.
 
    
    public void popLast() {
         if (head == null) {
             System.out.println("Empty List");
         } else if (head == tail) {
             head = null;
             tail = null;
             System.out.println("The list after the pop up is empty");
         } else {
             Node<T> temp = head;
             while (true) {
                 if (temp.getRefToNextNode() == tail) {
                     break;
                 }
                 temp = temp.getRefToNextNode();
             }
             tail = temp;
             tail.setRefToNextNode(null);
         }
     }