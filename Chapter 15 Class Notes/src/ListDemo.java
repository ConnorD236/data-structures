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
        String avenger = iterator.next();
        System.out.println(avenger); //should print Natasha
    }
}
