/**
 * Name: Zachary Pratt Gibbs
 * Assignment: Recursion
 * File: Recursion.java
 * Date: March 25, 2013
 * 
 * Description: This program prints out a singly linked list backward with the
 * help of recursion.
 */
package recursion;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class Recursion {
    /**
     * Prints a singly linked list backward recursively
     * @param sll The singly linked list to print backward.
     */
    public static void printBackward(SinglyLinkedList sllIn)
    {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll = (SinglyLinkedList)sllIn.clone();
        if(sll.getLength() == 1)
        {
            System.out.println(sll.find(0).getElement().toString());
            return;
        }
        String str = sll.delete(0).toString();
        printBackward(sll);
        System.out.println(str.toString());
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        sll.addAtHead("String 5");
        sll.addAtHead("String 4");
        sll.addAtHead("String 3");
        sll.addAtHead("String 2");
        sll.addAtHead("String 1");
        System.out.println("Forwards");
        sll.traverse();
        System.out.println("Backward");
        printBackward(sll);
        System.out.println("again");
        sll.traverse();
    }
}
