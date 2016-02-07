package uk.ac.ucl.cs.gc01.tutorial2;
import java.util.Arrays;

/**
 * Purpose: To remove a selected element from an array
 *
 * Description: The method remElement takes an array and integer as an argument and removes the numbered entry from the new array. 
 *
 * @author Nick
 *
 * @version Date: 15 Oct 2015 15:22:36
 */
public class Question2 {
	public static void main(String[] args) {
		String[] arr = { "The ", "quick ", "brown ", "fox ", "jumps ", "over ", "the ", "lazy ", "dog." };
		//Print out the new array as a string with the 7th element removed
		System.out.println(Arrays.toString((remElement(arr, 7))));
	}

	/**
	 * Removes the specified entry in the array
	 * @param arr
	 * @param num
	 * @return
	 */
	public static String[] remElement(String[] arr, int num) {

		String[] newarr = new String[arr.length - 1];
		int i = 0;
		while (i < arr.length) {
			if (i < num) {
				newarr[i] = arr[i];
				i++;
			} else if (i == num) {
				i++;
			} else if (i > num) {
				newarr[i-1] = arr[i];
				i++;
			}
		}
		return newarr;
	}
}
