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

        return this.first.data;
    }



    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst()
    {
        
        if(this.first == null)
            throw new NoSuchElementException();

        Object oldFirstObject = this.first.data;
        this.first = this.first.next;
        return oldFirstObject;
    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object newObject)
    {
        Node newNode = new Node();
        newNode.data = newObject;
        newNode.next = this.first;
        this.first = newNode;
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }


    public String toString()
    {
        ListIterator listIterator = listIterator();
        String allElements = "[";
        while(listIterator.hasNext()) {
            allElements += listIterator.next() + ", ";
        }
        allElements = allElements.substring(0,allElements.length()-2); //remove final ", "
        return allElements +"]";
    }


    //Class Node - when you make a class in a class, it acts like a private class, only being accessible to the outer class.
    // Node is static because it does Not need to access anything in LinkedList - use static classes when you just want to store information (the object that is the class will store the information)
    static class Node
    {
        public Node next;
        public Object data;
    }


    class LinkedListIterator implements ListIterator
    {
      //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next()
        {
            if(!hasNext())
                throw new NoSuchElementException();
            
            previous = position;

            if(position == null)
                position = first;
            else
                position = first.next;

            isAfterNext = true;

            return position.data;
        }



        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext()
        {
            // Check if the list is empty
            if(position == null) 
                return first != null;

            // The iterator has move so check the next position
            return position.next != null;
        }


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element)
        {
            // Check if the iterator is at the beginning of the list
            if(position == null) {
                addFirst(element);
                position = first; }
            
            else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;

                // Set the next element of the CURRENT position to point to the new node
                position.next = newNode; // NEW position
                position = newNode;
            }

            isAfterNext = false;
        }


        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove()
        {
            if(!isAfterNext)
                throw new IllegalStateException(); // iterator is not in the state to remove

            if(position == first) {
                removeFirst();
                position = null;
            }
            else{
                previous.next = position.next;
            }

            isAfterNext = false;
        }


        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element)
        {
            if(!isAfterNext) {
                throw new IllegalStateException();
            }

            position.data = element;
            // We don't have to reset isAfterNext because the structure of the list has not changed
        }



    }//LinkedListIterator
}//LinkedList
