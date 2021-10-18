package ArrayMaxProductOfTwoNums;

import java.util.Arrays;

public class MaxProductOfTwoNums {

	// Find the maximum product of two numbers in an unsorted array

	public static void main(String[] args) {

		int[] t1 = { 5, 3, 2, 5, 7, 0, 1 }; // 7 * 5 = 35
		int[] t2 = { -2, -1, -4, 5, 8, 0 }; // 8 * 5 = 40
		int[] t3 = { -20, -10, 3, 9, -8 };  // -20 * -10 = 200 

		System.out.println(maxProduct(t1));
		System.out.println(maxProduct(t2));
		System.out.println(maxProduct(t3));

		System.out.println();

		System.out.println(maxProduct2(t1));
		System.out.println(maxProduct2(t2));
		System.out.println(maxProduct2(t3));

		System.out.println();

		System.out.println(maxProduct3(t1));
		System.out.println(maxProduct3(t2));
		System.out.println(maxProduct3(t3));

	}

	// Time complexity: O(n^2) (quadratic)
	public static int maxProduct(int[] arr) {

		int length = arr.length;
		int max = Integer.MIN_VALUE;

		if (length < 2) {
			System.out.println("No max exists, returning single value");
			return max;
			// TODO: throw exception
		}

		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) { // for each element, iterate through rest of array
				if (arr[i] * arr[j] > max) { // check if product is larger than our current "max" value
					max = arr[i] * arr[j]; // if so, override max value with new product
				}
			}
		} 
		return max;
	}
	
	// To make more efficient, we can pre-sort the array using Arrays.sort()
	// Time complexity: < O(n^2)
	public static int maxProduct2(int[] arr) {
		
		int length = arr.length;
		
		if (length < 2) {
			System.out.println("No max value, returning single value");
			return Integer.MIN_VALUE;
		}
		
		Arrays.sort(arr);
		
		int maxProduct = arr[length - 2] * arr[length - 1]; // since its now sorted, multiply the last 2 indexes 
		int minProduct = arr[0] * arr[1];
		
		if (maxProduct > minProduct) { // this checks for 
			return maxProduct;
		} else {
			return minProduct;
		}
	}
	
	// Check to see if input is valid, then proceed.
	// Find potential max / min values first, then find product 
	// Time complexity: Linear O(n) --> OPTIMAL ! 
	public static int maxProduct3(int[] arr) {
		
		int length = arr.length;
		
		if (length < 2) {
			System.out.println("No max value, returning single value");
			return Integer.MIN_VALUE;
		}
		
		int max1 = arr[0];
		int max2 = Integer.MIN_VALUE;
		
		int min1 = arr[0];
		int min2 = Integer.MAX_VALUE;
		
		for (int i = 1; i < length; i++) {
			if (arr[i] < min1) { 
				min2 = min1;
				min1 = arr[i];
			} else if (arr[i] < min2) {
				min2 = arr[i];
			} else if (arr[i] > max1) {
				max2 = max1;
				max1 = arr[i];
			} else if (arr[i] > max2) {
				max2 = arr[i];
			}
		}
		
		int maxProduct = max1 * max2;
		int minProduct = min1 * min2;
		
		if (maxProduct > minProduct) { // This is a check to see if the 2 most negative numbers multiplied will result in a larger result than the 2 max numbers  
			return maxProduct;
		} else {
			return minProduct;
		}
	}
}
