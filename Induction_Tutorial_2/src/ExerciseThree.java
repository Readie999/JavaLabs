import java.util.Scanner;

/**
 * Purpose: Use of scanner for user input
 *
 * Description: Ask the user to enter their full name and display them together
 *
 * @author Nick
 *
 * @version Date: 2 Oct 2015 00:29:35
 */
public class ExerciseThree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your first name?");

		// save user�s first input in a String variable called �firstname�
		String firstname = scanner.nextLine();

		System.out.println("What is your second name?");
		// save user�s 2nd input in a String variable called �secondname�
		String secondname = scanner.nextLine();

		// print welcome message on screen including the saved input
		System.out.println("Hello! I thought that your name might be " + firstname + " " + secondname + "!");
		scanner.close();
	}
}
