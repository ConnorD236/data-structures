import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<String, Integer> map = new TreeMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();
                
                /* unmodified
                // Update the map here
                if(map.get(len) == null)
                String chunk = map.get(len);
                chunk = chunk + ", " + word;
                map.put(len, chunk);
                */
                
                // Modify Worked Example 15.1
                if(map.get(word) == null)
                    map.put(word, 1);
                else
                    map.put(word, map.get(word)+1);


            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            /*
            Map<Integer, String> tree = new TreeMap<>(map);
            Set<Integer> tree = map.keySet();
            System.out.println(keys);
            for(Integer i: keys)
                System.out.println(i+": "+map.get(i)); */
            Set<String> mapkeys = map.keySet();
            System.out.println(mapkeys);
            for(String i: mapkeys)
                System.out.println(i+": "+map.get(i));
            

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}