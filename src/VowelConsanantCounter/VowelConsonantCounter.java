package VowelConsanantCounter;

public class VowelConsonantCounter {
	
	// We want to count the vowels and consonants of a String
	// Assume string input only contains letter / whitespace

	public static void main(String[] args) {
		
		String s1 = "Hello";
		String s2 = " There is a mouse";
		String s3 = "David is a COOL dude";
		
		findVowelsAndConsonants(s1);
		findVowelsAndConsonants(s2);
		findVowelsAndConsonants(s3);

	}
	
	public static void findVowelsAndConsonants(String input) {
		int vowelCount = 0;
		int consonantCount = 0;
		String vowels = "aeiouy";
		String normalized = input.toLowerCase().trim();
		char[] normalizedArray = normalized.toCharArray(); // convert to Array so we can use ForEach loop
		
		for (char c: normalizedArray) {
			if (vowels.indexOf(c) != -1) { // indexOf() returns -1 if the char is NOT exisistent! 
				vowelCount++;
			} else if (c != ' ') {
				consonantCount++; // otherwise if it's NOT a vowel and NOT whitespace
			}
		}
		
		System.out.println("Vowels: " + vowelCount + " in " + input);
		System.out.println("Consonants: " + consonantCount + " in " + input);
		System.out.println(" \n");
		
	}

}
