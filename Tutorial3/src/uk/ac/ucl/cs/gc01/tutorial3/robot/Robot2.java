package uk.ac.ucl.cs.gc01.tutorial3.robot;

import java.util.Random;

public class Robot2 extends Robot1 {
	private String[] sayings = {};

	public static void main(String[] args) {

		Robot2 r1 = new Robot2();
		String[] u1 = { "Exterminate, Exterminate!", "I obey!", "You cannot escape.", "Robots do not feel fear.",
				"The Robots must survive!" };
		r1.setSayings(u1);
		System.out.println("Robot r1 says: ");
		for (int i = 0; i < 10; i++) {
			r1.speak();
		}
		System.out.println("\nRobot r2 says: ");
		Robot2 r2 = new Robot2();
		String[] u2 = { "I obey!" };
		r2.setSayings(u2);
		for (int i = 0; i < 10; i++) {
			r2.speak();
		}
	}

	// takes a string array and sets the possible sayings to be any of these
	// strings
	public void setSayings(String[] u) {
		sayings = u;

	}

	public void speak() {
		setSayings(sayings);
		Random rand = new Random();
		// create a random object
		System.out.println(sayings[rand.nextInt(sayings.length)]);
		// creates a random number between 0 and the length of the array of
		// possible sayings, then prints the entry in that part of the array

	}
}