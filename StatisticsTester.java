
/**
 * Lab 17.1 Statistics
 * 
 * Emily Zhuang
 * Mr. Lantsberger
 * APCS:Period 4
 * 18 November 2016
 */

import apcslib.*;
import chn.util.*;

public class StatisticsTester
{
    /**
     * Here is the main() method that reads values in from a text file with numbers 
     * and then calculates the average, standard deviation, and the mode of the data
     * set.
     */
    public static void main(String[] args)
    {
        FileInput inFile = new FileInput ("numbers.txt");
        FileOutput outFile = new FileOutput ("numbers.txt", "append");
        Statistics stats;
        int lines;
        
        int[] numbers = new int[1000];      //array of length 1000
        
        lines = 0;
        
        //converts all the values in the .txt file into an array
        for (int k = 0; k < 1000; k++)
        {
            if (inFile.hasMoreTokens())
            {
                numbers[k] = inFile.readInt();
                lines++;
            }
        }
        
        stats = new Statistics(lines);
        
        //prints the average, standard deviation, and mode in a terminal window
        System.out.println("Average: " + Format.left(stats.calcAve(numbers), 5,2));
        System.out.println("Standard deviation: " + Format.left(stats.calcSx(numbers), 5, 2));
        System.out.println("The mode(s) is(are): " + stats.findMode(numbers));
        
        //prints the average, standard deviation, and mode in the text file
        outFile.println("\nAverage: " + Format.left(stats.calcAve(numbers), 5,2));
        outFile.println("Standard deviation: " + Format.left(stats.calcSx(numbers), 5, 2));
        outFile.println("The mode(s) is(are): " + stats.findMode(numbers));
        outFile.close();
    }
}
