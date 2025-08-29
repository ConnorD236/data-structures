import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator(); //iterator
        while(iterator.hasNext()) {iterator.next();} //set iterator to right end

        for(int i=1; i<=strings.size(); i++) //for up to the length of the linked list...
        {
            String string = "anti-error statement";
            for(int l=i; l>0; l--) {string = iterator.previous();} //...move the iterator left that many times
            iterator.remove(); //remove string (returned by iterator.previous())

            while(iterator.hasNext()) {iterator.next();} //reset to right end
            iterator.add(string); //add string back at the end
            //and repeat, going farther back in the list
        }
    }
}