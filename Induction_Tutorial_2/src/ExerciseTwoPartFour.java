import java.util.Date;

/**
 * Purpose: To compare print & println, also learn how to display time and date
 *
 * Description: Print the current time and date along with Hello world
 *
 * @author Nick
 *
 * @version Date: 1 Oct 2015 22:47:58
 */
 
// Part 4
//using only one println call

public class ExerciseTwoPartFour {
 
    public static void main(String[] args) {
 
        Date date = new Date();
        // print the current time and date.
        System.out.println("Hello World! \n" +  date);
        // changing println to print means both are printed on the same line
    }
 
}