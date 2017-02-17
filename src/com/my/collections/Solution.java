package com.my.collections;

import java.util.*;

class Solution {
	public int solution(int[] A) {
		int j = 0;
		Pair[] arr = new Pair[A.length * 2];
		for (int i = 0; i < A.length; i++) {
			Pair s = new Pair((long) i - (long) A[i], true);
			arr[j] = s;
			j++;
			Pair e = new Pair((long) i + (long) A[i], false);
			arr[j] = e;
			j++;
		}
		Arrays.sort(arr, new Pair(0, true));

		long numIntersect = 0;
		long currentCount = 0;
		for (Pair p : arr) {
			if (p.start) {
				numIntersect += currentCount;
				if (numIntersect > 10000000) {
					return -1;
				}
				currentCount++;
			} else {
				currentCount--;
			}
		}

		return (int) numIntersect;
	}

	static private class Pair implements Comparator<Pair> {
		private long x;
		private boolean start;

		public Pair(long x, boolean start) {
			this.x = x;
			this.start = start;
		}

		public int compare(Pair p1, Pair p2) {
			if (p1.x < p2.x) {
				return -1;
			} else if (p1.x > p2.x) {
				return 1;
			} else {
				if (p1.start && p2.start == false) {
					return -1;
				} else if (p1.start == false && p2.start) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
}