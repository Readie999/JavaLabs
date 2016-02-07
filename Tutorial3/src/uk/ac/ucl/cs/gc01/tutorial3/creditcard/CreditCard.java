package uk.ac.ucl.cs.gc01.tutorial3.creditcard;

import java.util.Calendar;

public class CreditCard {
	private int expiryMonth, expiryYear;
	private String firstName, lastName, ccNumber;

	// constructor
	public CreditCard(int expiryMonth, int expiryYear, String firstName, String lastName, String ccNumber) {
		this.ccNumber = ccNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public String formatExpiryDate() {
		String year = Integer.toString(expiryYear);
		String news = Integer.toString(expiryMonth) + "/" + year.charAt(2) + year.charAt(3);
		return news;
	}

	public String formatFullName() {
		String full = firstName + " " + lastName;
		return full;
	}

	public String formatCCNumber() {
		String ccNo = ccNumber.substring(0, 4) + " " + ccNumber.substring(4, 8) + " " + ccNumber.substring(8, 12) + " "
				+ ccNumber.substring(12, 16) + " ";
		return ccNo;
	}

	public boolean isValid() {
		boolean valid = true;
		Calendar now = Calendar.getInstance();
		if (expiryYear > now.get(Calendar.YEAR)) {
		} else if (expiryYear == now.get(Calendar.YEAR)) {
			if (expiryMonth >= now.get(Calendar.MONTH)) {
			} else {
				valid = false;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	public String toString() {
		String info = "Number: " + formatCCNumber() + "\n" + "Expiry date: " + formatExpiryDate() + "\n"
				+ "Account holder: " + formatFullName() + "\n" + "Is valid: " + isValid();
		return info;
	}
}