package com.my.collections;

/**
 * Use selection sort - find smallest number and place it at correct position
 * This algorithm can also be used to find the median of an array.
 * 
 * @author Yogesh.Manware
 *
 */
public class FindDominator {

	public static void main(String[] args) {

		int[] a1 = { 1, 4, 2, 2 };
		int[] a2 = { 5, 10, 6, 5, 7, 5, 5 };
		int[] a3 = { 2, 3, 2, 3, 3 };

		System.out.println(findDominator(a1));
		System.out.println(findDominator(a2));
		System.out.println(findDominator(a3));

	}

	// find most frequently occurred number
	static int getMostFreqOccurredNum(int[] target) {

		int mostFreqOccurredNum = target[0]; // number having more occurrences
		int count = 1;

		for (int i = 1; i < target.length; i++) {
			if (mostFreqOccurredNum == target[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				mostFreqOccurredNum = target[i];
				count = 1;
			}
		}

		return mostFreqOccurredNum;
	}

	static int findDominator(int[] target) {

		// get majority number
		int mostFreqOccurredNumber = getMostFreqOccurredNum(target);

		int count = 0;

		for (int i = 0; i < target.length; i++) {
			if (target[i] == mostFreqOccurredNumber) {
				count++;
			}
		}

		if (count > target.length / 2) {
			return mostFreqOccurredNumber;
		}
		
		return -1;
	}

}
