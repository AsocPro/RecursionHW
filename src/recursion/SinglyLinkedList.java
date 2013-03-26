/*
 * Project: Recursion
 * File: SinglyLinkedList.java
 * @author Zachary Pratt Gibbs
 * Date: 25 March 2013
 * 
 * Description: This is the Singly Linked List class from the book.
 * It links Singly linked nodes together.
 * 
 * Modified from what is found in the book. 
 * 
 * Added public SinglyLinkedList findAll(E element)
 * This method finds all elements in the list that are equals to the element passed in
 * 
 * Added public void printedFindAll(E element)
 * This method is find all but instead of returning a singly linked list it prints found items.
 */
package recursion;

/**
 *
 * @author zachary
 */
public class SinglyLinkedList <E>
{
    private SLNode<E> head;
    private SLNode<E> tail;
    private int length;
    //it is not needed both tail and length just head and one
    //of them.
    
    public SinglyLinkedList()
    {
        // this is for dummy nodes where the head and the tail
        //do not have values and are not part of the list
        //if you did not want to do this then you would set 
        //them to null values.
        tail = new SLNode();
        head = new SLNode(null, tail);
        length = 0;
    }
    /** 
     * they use a visitor in the book but we will not implement
     * it all the way so we are going to print it all out.
     * Prints the index number before each element.
     */
    public void traverse()
    {
        SLNode<E> cursor = head.getSuccessor();
        int index = 0;
        while(cursor != tail)
        {
            System.out.println(cursor.getElement());
            //this is where we would have visited the node. 
            //but we are not doing visitors
            cursor = cursor.getSuccessor();
            index++;
        }
    }
    public SLNode<E> find(int pos)
    {
        if(pos<0 || pos >= this.length)
        {
            throw new IndexOutOfBoundsException();
        }
        SLNode<E> cursor = head.getSuccessor();
        
        for(int index = 0; index < pos; ++index)
        {
            cursor = cursor.getSuccessor();
        }
        return cursor;
    }
    public SLNode<E> find(E element)
    {
        SLNode<E> cursor = head.getSuccessor();
        
        while(cursor != tail)
        {
            if(cursor.getElement().equals(element))
            {
                return cursor;
            }
            else
            {
                cursor = cursor.getSuccessor();
            }
        }
        return null;
    }
    /**
     * Finds all the elements in a SLL
     * @param element Element being searched for
     * @return SinglyLinkedList of all found items.
     */
    public SinglyLinkedList findAll(E element)
    {
        SinglyLinkedList<E> list = new SinglyLinkedList<>();
        SLNode<E> cursor = head.getSuccessor();
        
        while(cursor != tail)
        {
            if(cursor.getElement().equals(element))
            {
                list.addAtTail(cursor.getElement());
            }
            cursor = cursor.getSuccessor();
        }
        return list;
    }
    /**
     * Prints all elements in the SLL that are equal to element
     * @param element Element being searched for.
     */
    public void printedFindAll(E element)
    {
        String list = "";
        int index = 0;
        SLNode<E> cursor = head.getSuccessor();
        
        while(cursor != tail)
        {
            if(cursor.getElement().equals(element))
            {
                list = list + index + ": " + cursor.getElement() + "\n";
            }
            cursor = cursor.getSuccessor();
            index++;
        }
        if(list.equals(""))
        {
            System.out.println("None Found");
        }
        else
        {
            System.out.println(list);
        }
    }
    public void addAtHead(E element)
    {
        SLNode<E> newNode = new SLNode<>(element,null);
        newNode.setSuccessor(head.getSuccessor());
        head.setSuccessor(newNode);
        length++;
    }
    public void addAtTail(E element)
    {
        SLNode<E> newNode = new SLNode<>(element, null);
        if(length<0)
        {
            SLNode<E> lastNode = find(this.length-1);
            newNode.setSuccessor(lastNode.getSuccessor());
        
            lastNode.setSuccessor(newNode);
        }
        else
        {
            newNode.setSuccessor(head.getSuccessor());
            head.setSuccessor(newNode);
        }
        length++;
    }
    public void insert(E element,int pos)
    {
        if(pos<0 || pos > this.length)// changed took out = cause if pos = length puts it at end
        {
            throw new IndexOutOfBoundsException();
        }
        //java 7 there is a feature that is a diamond operator
        //this is new in 7 it will take from the left
        // you can if it is a child of the other type
        
        if(pos == 0)
        {
            addAtHead(element);
        }
        else if(pos == length)
        {
            addAtTail(element);
        }
        else 
        {
            SLNode<E> newNode = new SLNode<>(element, null);
            
            SLNode<E> prevNode = find(pos-1);
            
            newNode.setSuccessor(prevNode.getSuccessor());
            prevNode.setSuccessor(newNode);
            length++;
        }
    }
    public E delete(int pos)
    {
        //write check position method
        if(pos<0 || pos >= this.length)
        {
            throw new IndexOutOfBoundsException();//unchecked exception
        }
        SLNode<E> prevNode;
        if(pos == 0)
        {
            prevNode = head;
        }
        else
        {
            prevNode = find(pos-1);
        }
        SLNode<E> delNode = prevNode.getSuccessor();
       
        prevNode.setSuccessor(delNode.getSuccessor());
        delNode.setSuccessor(null);//just for completeness
        
        length--;
        
        return delNode.getElement();
    }
    public int getLength()
    {
        return length;
    }
}
