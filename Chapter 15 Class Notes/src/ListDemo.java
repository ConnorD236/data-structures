import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The add, addFirst, and addLast methods can be used to populate lists. */
        //ADDLAST AND ADDFIRST ARE LINKEDLIST METHODS
        LinkedList<String> staff = new LinkedList<>();
        staff.addFirst("Tony");
        staff.add("Natasha");
        staff.addLast("Peter");
        staff.add("Steve");
        System.out.println(staff);
        //Current list: TNPS

        /* The listIterator method creates a new list iterator, poistioned at (before) the head of the list. Need a list iterator to iterate through lists.
         * The | is used to represent the iterator position
        */
        ListIterator<String> iterator = staff.listIterator(); // |TNPS
        
        /* The next method advances the iterator OVER the next element in the list. */
        iterator.next(); // T|NPS

        /* The next method also returns the element that the iterator passes over. */
        String avenger = iterator.next(); // TN|PS
        System.out.println(avenger); //should print Natasha

        /* The add method inserts an element at the iterator position.
         * The iterator is then positioned AFTER the element that was added.
         */
        iterator.add("Clint"); // TNC|PS
        iterator.add("Bruce"); // TNCB|PS
        System.out.println(staff);

        /* The remove method can ONLY be called after calling next or previous; not after other methods such as add. */
        //iterator.remove(); //IllegalStateException - Can't remove after adding - like removing something from a list while looping through it.
        // The remove method removes the element RETURNED after calling next or previous.
        iterator.next(); // TNCBP|S
        iterator.remove(); // Peter is remove -> TNCB|S
        System.out.println(staff);

        /* The set method updates the element returned bu the last call to next or previous. Again, must call next or previous only before being able to call. */
        iterator.previous(); //TNC|BS
        iterator.set("Thor"); //TNC|TS Replaces Bruce, because Bruce was returned by previous.
        System.out.println(staff);

        /* The hasNext method is used to determine if there is a next node after the iterator. The hasNext method is often used in the condition of a while loop. */
        iterator = staff.listIterator(); // |TNCTS Replaces the iterator we have with a new one, at the beginning of the list. Resets the iterator.
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Natasha")) { // TN|CTS
                iterator.remove(); // T|CTS
            }
        } //TCTS|

        /* Enchanced for loops work with linked lists as well. */
        for (String n: staff) {
            System.out.print(n + " ");
        }
        System.out.println();
        
        /* ConcurrentModificationException
         * 
         * CANNOT modify a linked list while using an iterator
         * UNLESS you use the iterator to do the modification.
         * (have to use an iterator while modifying the list.)
         */
        iterator = staff.listIterator(); // |TCTS
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Tony")) {
                //staff.remove("Tony"); //ConcurrentModificationException error happens when the iterator isn't used to remove things during a loop, because that's the iterator's job (for safety).
                
            }
        }

        //There is an iterator in the background - results in same problem.
        for (String n: staff) {
            if (n.equals("Tony")) {
                staff.add("T'Challa");
            }
        }

        //System.out.println(staff);
    }
}
