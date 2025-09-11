import java.util.*;

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> gradebook = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                System.out.println("Who would you like to add?");
                String name = in.next();
                System.out.println("What is their course grade?");
                String grade = in.next();
                gradebook.put(name, grade);

            } else if (input.equals("R"))
            {
                System.out.println("Who would you like to remove?");
                String name = in.next();
                gradebook.remove(name);
                
            } else if (input.equals("M"))
            {
                System.out.println("Who would you like to modify?");
                String name = in.next();
                System.out.println("What is their course grade?");
                String grade = in.next();
                gradebook.put(name, grade);
                
            } else if (input.equalsIgnoreCase("P"))
            {
                Map<String, String> sortedGradebook = new TreeMap<>(gradebook);
                Set<String> keys = sortedGradebook.keySet();
                for(String s: keys) {
                    System.out.println(s+" "+gradebook.get(s));
                }
                
                
            } else
            {
                done = true;
            }
        }
    }
}
