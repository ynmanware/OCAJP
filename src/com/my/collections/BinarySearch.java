package com.my.collections;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 9, 12, 14, 15, 16 };
		System.out.println(binarySearch(arr, 16, 0, arr.length - 1));

	}

	static int binarySearch(int[] target, int value, int left, int right) {
		if (left > right) {
			return -1;
		}

		int middle = (left + right) / 2;
		if (target[middle] == value) {
			return middle;
		}

		if (target[middle] > value) {
			return binarySearch(target, value, left, middle - 1);
		} else {
			return binarySearch(target, value, middle + 1, right);
		}
	}

}
