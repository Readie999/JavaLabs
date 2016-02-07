package uk.ac.ucl.cs.gc01.tutorial3.robot;

public class Robot1 {
	private double batteryCharge = 5.0; // instance variable

	public void batteryReCharge(double c) {
		batteryCharge += c;
		System.out.println("Battery charge is: " + batteryCharge);
	}

	public void move(int distance) {
		for (int i = 1; i <= distance; i++) {
			if (batteryCharge >= 0.5) {
				System.out.print("[" + i + "]" + " ");
				batteryCharge -= 0.5;
				// take 0.5 off the charge for each unit of movement
			} else {
				System.out.println("Out of power. Please recharge!");
			}
		}
	}
}
