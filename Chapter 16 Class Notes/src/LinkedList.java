import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    // first refers to the first node in the list
    // If the list is empty, first will be null
    private Node first;

    
    /**
        Constructs an empty linked list.
    */
    public LinkedList()
    {
        this.first = null;
    }



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst()
    {
        if(this.first == null)
            throw new NoSuchElementException(); //creates exception object (like return (*create new object*); )
        else
            return this.first.data;
    }



    /**
        Removes the first element in the linked list.
        @return the removed element
    */





    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */





    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */





    //Class Node - when you make a class in a class, it acts like a private class, only being accessible to the outer class.
    // Node is static because it does Not need to access anything in LinkedList - use static classes when you just want to store information (the object that is the class will store the information)
    static class Node
    {
        public Node next;
        public Object data;
    }


    class LinkedListIterator //implements ListIterator
    {
      //private data


        /**
            Constructs an iterator that points to the front
            of the linked list.
        */


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */





        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */




    }//LinkedListIterator
}//LinkedList
