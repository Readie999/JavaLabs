package uk.ac.ucl.cs.gc01.tutorial3.creditcard;

public class CreditCardTester {
	public static void main(String[] args) {
		CreditCard cc1 = new CreditCard(10, 2014, "Bob", "Jones", "1234567890123456");
		CreditCard cc2 = new CreditCard(8, 2016, "Fred", "Bloggs", "1456576132536998");
		System.out.println(cc1.toString());
		System.out.println();
		System.out.println(cc2.toString());
	}
}
