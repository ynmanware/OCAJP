package com.my.collections;

public class SelectionSort {

	public static void main(String[] args) {

	}

	static void sort(int[] target) {

		int i, j, tmp, smallestNumberIndex;

		for (i = 0; i < target.length - 1; i++) {

			smallestNumberIndex = target[i];

			for (j = i + 1; j < target.length; j++) {
				if (target[j] < target[smallestNumberIndex]) {
					smallestNumberIndex = j;
				}
			}

			tmp = target[i];
			target[i] = target[smallestNumberIndex];
			target[smallestNumberIndex] = tmp;
		}

		// now we a sorted array, count the occurrences
		if (target.length % 2 == 0) {
			for (int k = 0; k < target.length; k++) {

			}
		}

	}
}
