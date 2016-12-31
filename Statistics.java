
/**
 * Lab 17.1 Statistics
 * 
 * Emily Zhuang
 * Mr. Lantsberger
 * APCS:Period 4
 * 18 November 2016
 */

import chn.util.*;

public class Statistics
{    
    private int myLines;            //how many elements in the array
    
    /**
     * Constructor for objects of class Statistics
     * Lines refers to the number of elements in the array.
     */
    public Statistics(int lines)
    {
        myLines = lines;            //how many elements in the array
    }
    
    /**
     * This method adds all the values in the array together and divide
     * by the total number of elements in the array. 
     */
    public double calcAve(int[] numbers)
    {
        long sum = 0;               //sum of all the numbers in array numbers[]
        
        for (int k = 0; k < myLines; k++)
        {
            sum += numbers[k];      //adds all the values together
        }
        
        return (double)sum / myLines;       //returns the mean of the data set
    }
    
    /**
     * This method calculates the standard deviation of all the numbers in 
     * the array by calling calcAve() and the using the formula for 
     * standard deviation.
     */
    public double calcSx(int[] numbers)
    {
        double ave;                         //average calculated from calcAve()
        long numerator = 0;                 
        
        ave = calcAve(numbers);             
        
        for (int k = 0; k < myLines; k++)
        {
            numerator += Math.pow(numbers[k] - ave, 2);     //calculates the numerator of the Sx
        }
        
        return Math.sqrt(numerator / (myLines - 1));        //returns the standard deviation
    }
    
    /**
     * This method finds the mode/modes of an array by traversing through
     * the array and tallying how often each value appears. And then traversing
     * through the array of tally marks to find which values have the most
     * tallies and it returns those values. 
     */
    public String findMode(int[] numbers)
    {
        int[] tally = new int[101]; //keeps a tally of all the numbers in the numbers array
        int[] modes = new int[101]; //an array of all the modes
        int max, many;              //max is how many repetitions the mode repeats
                                    //many is how many modes there are
        String output = "";         //a string with all the modes
        max = -1;                   //instantiates max as smaller than the possible range
        many = 0;                   
        
        //loop that tallies all the values
        for (int k = 0; k < myLines; k++)
        {
            tally[numbers[k]]++;
        }
        
        //loop that traverses through the array to find the value with the most reoccurances 
        for (int k = 0; k < 101; k++)
        {
            if (tally[k] > max)
                max = tally[k];
        }
        
        //loop that fills another array with all the modes
        for (int k = 0; k < 101; k++)
        {
            if (tally[k] == max)
            {
                modes[many] = k;
                many++;
            }
        }
        
        //loop that converts all the modes into a string
        for (int k = 0; k < many; k++)
        {
            output += "\t" + modes[k];
        }
        
        return output;
    }
}
