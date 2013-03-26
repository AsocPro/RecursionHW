/*
 * Project: Recursion
 * File: SLNode.java
 * @author Zachary Pratt Gibbs
 * Date: 25 March 2013
 * 
 * Description: This is the Singly Linked Node class from the book.
 */
package recursion;

/**
 *
 * @author zachary
 */
public class SLNode <E>{
    
    /**
     * Will have element and a pointer to the next node
     */
    private E element;
    private SLNode successor;
    
    public SLNode()
    {
        this.element = null;
        this.successor = null;
    }
    public SLNode(E element, SLNode<E> node)
    {
        this.element = element;
        this.successor = node;
    }
    public E getElement()
    {
        return this.element;
    }
    public void setElement(E element)
    {
        this.element = element;
    }
    public SLNode getSuccessor()
    {
        return this.successor;
    }
    public void setSuccessor(SLNode successor)
    {
        this.successor = successor;
    }
}
