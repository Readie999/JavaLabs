package uk.ac.ucl.cs.gc01.tutorial2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Purpose: To practice the use of ArrayList
 *
 * Description: Create an array list consisting of 100 random integers. 
 * Perform a sum of the even values in the list.
 * Remove all the odd entries and place them at the end of the list
 * Create an array from the array list
 *
 * @author Nick
 *
 * @version Date: 15 Oct 2015 15:38:07
 */
public class Question3 {
	public static void main(String[] args) {
		// create an array list of integers
		ArrayList<Integer> aList = new ArrayList<Integer>(100);
		// create a new random variable
		Random rand = new Random();
		int sum = 0;
		// for loop adds 100 random numbers to the array aList
		for (int i = 0; i < 100; i++) {
			aList.add(rand.nextInt(101));
			// range is 0-100
			if (Question1.isEven(aList.get(i))) {
				sum = sum + aList.get(i);
			}
		}
		System.out.println(aList);
		// the below removes all odd integers and placs them at the end of the
		// list. Must start from RHS since when removing each integer the index
		// of the elements on the right to the one being removed all decrease by 1
		System.out.println("Sum of the even numbers is: " + sum);
		for (int j = 99; j > -1; j--) {
			if (!Question1.isEven(aList.get(j))) {
				int odd = aList.get(j);
				aList.remove(j);
				aList.add(odd);
			}

		}
		int[] array = new int[100];
		
		// create an array of size 100 
		for(int i=0; i<100; i++){
		array[i] = aList.get(i);
		//set each array entry as that of the arrayList.
		}
		System.out.println(aList.toArray().toString());
		//prints the value of the array with all the odd values at the end.
		System.out.println(Arrays.toString(array));

	}

}
