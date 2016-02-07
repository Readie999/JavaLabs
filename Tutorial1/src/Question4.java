
/**
 * Purpose: Convert a given Byte value to B, KB, MB, GB dependent on the size.
 *
 * Description: Uses both arrays, for loop and if loop to convert the byte value and choose which 
 * unit makes the most sense to convert it to.
 *
 * @author Nick
 *
 * @version Date: 8 Oct 2015 17:36:36
 */
public class Question4 {
	public static void main(String[] args) {
		ConvertByte(537395200);
	}

	public static void ConvertByte(int a) {
		final String[] UNITS = { "B", "KB", "MB", "GB" };
		double[] Conversion = new double[4];
		String[] combo = new String[4];
		Conversion[0] = a;
		combo[0] = Conversion[0] + UNITS[0];
		for (int i = 1; i < 4; i++) {
			Conversion[i] = (Conversion[i - 1]) / (Math.pow(2, 10));
			combo[i] = Conversion[i] + UNITS[i];
		}
		if (a < 1024) {
			System.out.println(combo[0]);
		} else if (a > Math.pow(2, 10) && a < Math.pow(2, 20)) {
			System.out.println(combo[1]);
		} else if (a > Math.pow(2, 20) && a < Math.pow(2, 30)) {
			System.out.println(combo[2]);
		} else {
			System.out.println(combo[3]);
		}

	}
}