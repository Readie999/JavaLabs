package uk.ac.ucl.cs.gc01.tutorial2;
import java.util.Scanner;

/**
 * Purpose: User inputs a number and then the output is whether the number is
 * odd or even
 *
 * Description: Look at the different ways of returning a boolean value - if/else statement, local variable, using the boolean properties
 *
 * @author Nick
 *
 * @version Date: 15 Oct 2015 13:58:52
 */
public class Question1 {
	public static void main(String[] args) {
		System.out.println("Enter a number to see if it is even.");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		System.out.println(isEven(input));
		scanner.close();
	}

	/**
	 * Returns true if given integer is even, false otherwise
	 * 
	 * @param number
	 * @return
	 */
	//part2
	/* public static boolean isEven (int number) {
		 boolean isEven = true;
		 if (number % 2 == 0){
		 }
		 else{
			 isEven = false;
		 }
		return isEven ;
		}
		*/
	//part3: write program using only one line and no if else statement:
/*	public static boolean isEven(int number) {
		boolean isEven = (number % 2 == 0);
		return isEven;
	}
	*/
	//part 4
	//write program without using a local variable:
	public static boolean isEven(int number) {
		return (number % 2 == 0);
	}
}
