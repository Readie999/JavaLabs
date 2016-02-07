/**
 * Purpose: Simple Example Program
 *
 * Description: This program prints out the message Hello World
 *
 * @author Nick
 *
 * @version Date: 1 Oct 2015 22:34:31
 */
public class ExerciseOne{

	public static void main(String[] args) {
		int sum = 0;
        for (int i = 0, j = 0; i < 5 & j < 5; ++i, j = i + 1)
            sum += i;
     System.out.println(sum);

	}

}