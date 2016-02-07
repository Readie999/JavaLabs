import java.util.Scanner;

/**
 * Purpose: To practice if else statements with the use of scanner
 *
 * Description: Ask the users name and the system responds accordingly
 *
 * @author Nick
 *
 * @version Date: 2 Oct 2015 09:19:27
 */
public class ExerciseFour {
	public static void main(String [ ] args ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your name?");
		 String name = sc.nextLine() ;
		if (name.isEmpty()) {
		System.out.println("Fine, don�t tell me your name. Goodbye!");
		}else if(name.length()<2){
			System.out.println("Your name cannot be less than two characters!");
		}else {
		System.out.println("Hello! I thought that your name might be "+ name + "!");
		}
		sc.close();
		}
}
