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
     
# Algo for AddAfter

This means adding a node after a particular node.

Steps to be followed are 

Say we have node n1 after which we need to add a new node n2.

Case 1 : when the list is empty, add the new node to the head and tail.

Case 2 : When the list has only one element or if the node is added at the end.

    Step 1 : Create a new node n2 and assign the key to it

    Step 2 : check for the reference of the next node of the node(n1), if it blank

    Step 3 : Add the reference of the new node to the tail.

    Step 4 : Mark the new node as tail.

Case 3 : when the list is not empty or the last reference of the node n1 is not blank.

    Step 1 : Create a new node n2 and assign the key to it

    Step 2 : add the reference of the next node of the node(n1) to the new node(n2)

    Step 3 : Add the reference of the new node(n2) to the existing node(n1).
    
    
    public void addAfter(Node<T> node, T key) {
    
        Node<T> n2 = new Node<T>();
        n2.setKey(key);

        /*Case 1 : When Node is added to Empty Linked List*/
        
        if (head == null) {
            head = n2;
            tail = n2;
        } else {
        
            /*Case 2 When the Node is added after the last node*/
            
            if (node.getRefToNextNode() == null) {
                node.setRefToNextNode(n2);
            } 
            
            /*Case 3 : when node is added in between*/
            
            else {
                n2.setRefToNextNode(node.getRefToNextNode());
                node.setRefToNextNode(n2);
            }
        }
    }
    
# Stack

Represents an abstract data type, LIFO

Operations of a Stack are 

1. Push(key) - adds a key to the collection
2. Key Pop() - removes and returns most recently added key from the collection
3. key Top() - returns most recently added key to a collection

Example of stack.
Balanced String

A string consists of sequence of brackets, to determine which has got a pair.

Example String str = "()[]()("

We need to check how many do not have a pair.

Steps to be followed. Assumptions the pair should have opening first and closing after 
opening.

1. iterate each character in the loop.

2. if you come across opening braces such as ( or { or [, put it in a stack

3. else pop the element from the stack and compare with the element, if it doesnot match 
in the sense opening does not have a closing, return false. The string is not balanced.

String parenthesis = "()()[]"

public static boolean isBalanced(String parenthesis) {

        char[] valuesinString = parenthesis.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : valuesinString) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty())
                    return false;
                Character fromStack = stack.pop();

                if ((fromStack == '(' && c != ')') || (fromStack == '{' && c != '}') || (fromStack == '[' && c != ']')) {
                    return false;
                }
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
            
    }
    
#Stack

Abstract data Type with the following operations.
    
    
# Queue

Abstract Datatype with the following operations, Also Known as FIFO

1. Enqueue(key) : Adds key to a collection.

2. key dequeue : removes a key from the collection.

3. Boolean isEmpty;