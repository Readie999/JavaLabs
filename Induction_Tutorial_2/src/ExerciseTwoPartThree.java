import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Purpose: To compare print & println, also learn how to display time and date
 *
 * Description: Print the current time and date along with Hello world
 *
 * @author Nick
 *
 * @version Date: 2 Oct 2015 13:17:24
 */
public class ExerciseTwoPartThree {
	    public static void main(String[] args) { 
	    System.out.print("Hello World!");
	 	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
	 	//create a date object Date date = new Date(); //print the current time and date.
	 	Date date = new Date();
	 	System.out.print(dateFormat.format(date)); 
	 	//changing println to print means both are printed on the same line }
	 }
}
