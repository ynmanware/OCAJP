package com.my.collections;

public class EquilibriumIndex {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 1 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {

		long sum = 0; // initialize sum of whole array
		long leftsum = 0; // initialize leftsum
		int i, n = arr.length;

		/* Find sum of the whole array */
		for (i = 0; i < n; ++i)
			sum += arr[i];

		for (i = 0; i < n; ++i) {
			sum -= arr[i]; // sum is now right sum for index i

			if (leftsum == sum)
				return i;

			leftsum += arr[i];
		}

		/* If no equilibrium index found, then return 0 */
		return -1;
	}
}
