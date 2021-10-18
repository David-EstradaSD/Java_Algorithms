package Palindrome;

import java.util.stream.IntStream;

public class Palindrome1 {

	// Palindrome reads the same forwards as it does backwards
	// Ex) racecar, madam, kayak, radar, civic, refer, rotor

	public static void main(String[] args) {

		// s1 - s4 should all return true (palindromes)
		// s5 - s8 should all return false (NOT palindromes)
		String s1 = "maDam";
		String s2 = "raceCar";
		String s3 = "kayak";
		String s4 = "ciVic";

		String s5 = "david";
		String s6 = "devie";
		String s7 = "hello";
		String s8 = "awesome";
		
		System.out.println(traditionalChecker(s1));
		System.out.println(traditionalChecker(s2));
		System.out.println(traditionalChecker(s3));
		System.out.println(traditionalChecker(s4));
		System.out.println(traditionalChecker(s5));
		System.out.println(traditionalChecker(s6));
		System.out.println(traditionalChecker(s7));
		System.out.println(traditionalChecker(s8));
		
		System.out.println("______________\n");
		
		System.out.println(streamsAPIChecker(s1));
		System.out.println(streamsAPIChecker(s2));
		System.out.println(streamsAPIChecker(s3));
		System.out.println(streamsAPIChecker(s4));
		System.out.println(streamsAPIChecker(s5));
		System.out.println(streamsAPIChecker(s6));
		System.out.println(streamsAPIChecker(s7));
		System.out.println(streamsAPIChecker(s8));
		

	}

	public static boolean traditionalChecker(String original) {

		String normalized = original.toLowerCase(); // normalize the input
		StringBuilder reversed = new StringBuilder(); // create "reversed" String object

		// String reversed = new StringBuilder(normalized).reverse().toString(); // cheating using .reverse() method

		for (int i = normalized.length() - 1; i >= 0; i--) {
			reversed.append(normalized.charAt(i));
		} // for palindrome, we want to iterate BACKWARDS!

		return normalized.equals(reversed.toString()); // return the equals check boolean
	}
	
	
	
	

	public static boolean streamsAPIChecker(String original) {
		String normalized = original.toLowerCase();

		return IntStream.range(0, normalized.length() / 2)
				.allMatch(i -> normalized.charAt(i) == 
					normalized.charAt(normalized.length() - i - 1));

	}

}
