import java.util.Scanner;
import java.util.*;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        //making a set with the numbers 2-n
        Set<Integer> s = new HashSet<>();
        for(int i=2; i<=n; i++)
        {
            s.add(i);
        }

        for(int i=2; i<=n; i++)
        {
            for(int m=2; m<=n; m++)
            s.remove(m*i);
        }

        System.out.print(s);





    }
}
