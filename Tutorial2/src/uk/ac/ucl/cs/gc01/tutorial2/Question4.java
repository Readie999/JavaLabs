package uk.ac.ucl.cs.gc01.tutorial2;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/**
 * Purpose: To use java vectors and scanner to read user input
 *
 * Description: User enters up to 50 real numbers, can stop the entering process by entering 0 
 * these numbers are then sorted and then printed
 *
 * @author Nick
 *
 * @version Date: 18 Oct 2015 18:04:45
 */
public class Question4 {
	public static void main(String[] args) {
		Vector<Double> values = new Vector<Double>(50);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter up to 50 real numbers followed by a 0 to mark the end of the entries");
		for(int i=0; i<50; i++){
			double entry =scanner.nextDouble();
			//next double entered in console is called entry
			// keep track of how many numbers have been entered
			if(entry==0){break;}
			System.out.println(49-i +" 	entries remaining");
			//if 0 is entered then the loop breaks.
			values.add(entry);
			// add each entry in the vector.

		}
		//line below sorts the values in ascending order
		Collections.sort(values);
		System.out.println("Sorted: "+ values);
		scanner.close();
	}
}
