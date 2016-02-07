
import java.util.Arrays;

/**
 * Purpose: To investigate for loops to provide values to arrays 
 *
 * Description: Produce one array called numbers where each entry is twice the previous. 
 * Also, another array called mean, which provides the mean value of the neighbouring elements in numbers.
 *
 * @author Nick
 *
 * @version Date: 8 Oct 2015 15:53:49
 */
public class Question3 {
	public static void main(String[] args) {
		int numbers[] = new int[20];
		numbers[0] = 1;
		for (int i = 1; i < 20; i++) {
			numbers[i] = 2 * numbers[(i - 1)];
		}
		
		int mean[] = new int[20];
		mean[0]= numbers[0];
		mean[19]=numbers[19];
		
		for(int i=1; i<19; i++){
			mean[i]= (numbers[i-1] + numbers[i+1])/2;
		}
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(mean));
	}
}
