import java.util.*;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    
    Stack<Pair> stack;
    Pair pair;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        stack = new Stack<>();
        pair = new Pair(row, column);
        stack.push(pair);

        int counter = 1;
        while(stack.size() > 0)
        {
            //handling current pair - test and manage number
            Pair current = stack.pop();
            if(pixels[current.getRow()][current.getColumn()] == 0)
            {
                pixels[current.getRow()][current.getColumn()] = counter;
                counter++;
            
                //then check neighbors

                //if(exists && zero)
                //  push(Pair(edited row, edited column));
                //otherwise, left alone
                if(current.getRow()-1 > -1      && pixels[current.getRow()-1][current.getColumn()  ] == 0)
                    stack.push(new Pair(current.getRow()-1, current.getColumn()));
                if(current.getRow()+1 < SIZE    && pixels[current.getRow()+1][current.getColumn()  ] == 0)
                    stack.push(new Pair(current.getRow()+1, current.getColumn()));
                if(current.getColumn()-1 > -1   && pixels[current.getRow()  ][current.getColumn()-1] == 0)
                    stack.push(new Pair(current.getRow(), current.getColumn()-1));
                if(current.getColumn()+1 < SIZE && pixels[current.getRow()  ][current.getColumn()+1] == 0)
                    stack.push(new Pair(current.getRow(), current.getColumn()+1));
            
            }
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
