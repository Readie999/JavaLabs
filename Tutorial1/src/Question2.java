
/**
 * Purpose: Create a calculator that takes user input
 *
 * Description: Simple calculator that can perform addition, subtraction, multiplication, division 
 * and display the correct answers
 *
 * @author Nick
 *
 * @version Date: 8 Oct 2015 15:14:09
 */

import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) {
		System.out.println(
				"Simple Calculator. Please choose an operation: \n 1. Add \n 2. Subtract \n 3. Multiply \n 4. Divide \n 5. Factorial \n 6. Exit");

		Scanner scanner = new Scanner(System.in);
		int value1 = scanner.nextInt();
		if (value1 >= 1 && value1 <= 4) {
			System.out.println("Please provide two numbers to perform the method chosen above.");

			int value2 = scanner.nextInt();
			int value3 = scanner.nextInt();
			switch (value1) {
			case 1:
				System.out.println("Answer:" + add(value2, value3));
				break;
			case 2:
				System.out.println("Answer:" + subtract(value2, value3));
				break;
			case 3:
				System.out.println("Answer:" + multiply(value2, value3));
				break;
			case 4:
				System.out.println("Answer:" + divide(value2, value3));
				break;
			}

		} else if (value1 == 5) {
			System.out.println("Please provide one number to perform the method chosen above.");

			int value2 = scanner.nextInt();

			System.out.println("Answer:" + factorial(value2));
		} else if (value1 == 6) {
			scanner.close();
			exit();
		} else {
			System.out.println("Invalid section. Please run again");
		}

	}

	public static int add(int a, int b) {
		int result = a + b;
		return result;
	}

	public static int subtract(int a, int b) {
		int result = a - b;
		return result;
	}

	public static int multiply(int a, int b) {
		int result = a * b;
		return result;
	}

	public static double divide(double a, double b) {
		double result = a / b;
		return result;
	}

	public static int factorial(int a) {
		int val = 1;
		while (a > 1) {
			val = val * (a);
			a--;
		}
		return val;
	}

	public static void exit() {
		System.exit(0);
	}

}
