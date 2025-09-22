import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "C:\\Users\\cjdoyle\\Documents\\GitHub\\data-structures/Chapter 15 Activities/HTMLChecker/src/TagSample1.html";
        //String filename = "C:\\Users\\cjdoyle\\Documents\\GitHub\\data-structures/Chapter 15 Activities/HTMLChecker/src/TagSample2.html";
        //String filename = "C:\\Users\\cjdoyle\\Documents\\GitHub\\data-structures/Chapter 15 Activities/HTMLChecker/src/TagSample3.html";
        Stack<String> tags = new Stack<>();
        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            //Loop through all tags
            while(in.hasNext()) {
                
                String tag = in.next();

                if(tag.substring(1,2).equals("/")) //closed tag test
                {
                    if(tags.size() == 0 || !(tags.peek().substring(1,2).equals(tag.substring(2,3)))) // if empty stack, or the letters of the tags aren't the same
                        {System.out.println("Invalid tags!");                                                                               // tell user the tags are wrong
                        System.out.println("Tags stack currently - "+tags.toString()+" while trying to process "+tag);
                        return;}
                    else if(tags.peek().substring(1,2).equals(tag.substring(2,3)))  // else if tag letters are the same, remove the tag
                        tags.pop();
                    else
                        System.out.println("what did you code wrong");
                        
                }
                else
                    tags.push(tag);
            }

            
                // success output
                System.out.println("If you see this, the HTML tags work!");
                System.out.println("Tags stack - "+tags.toString());



        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
