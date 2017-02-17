package codility;
import java.util.Arrays;

class Solution {
	public static int solution(int[] H) {

		long total = H.length;

		for (int i = 0; i < H.length; i++) {

			int[] l = {};

			if (i > 0) {
				l = Arrays.copyOfRange(H, 0, i);
			}

			int[] r = {};

			if (i < H.length - 1) {
				r = Arrays.copyOfRange(H, i + 1, H.length);
			}

			Arrays.sort(l);
			Arrays.sort(r);

			int[] validL = {}, validR = {};

			// find the all number which are greater than H[i]
			for (int j = 0; j < l.length; j++) {
				if (H[i] <= l[j]) {
					validL = Arrays.copyOfRange(l, j, l.length);
					break;
				}
			}

			for (int j = 0; j < r.length; j++) {
				if (H[i] <= r[j]) {
					validR = Arrays.copyOfRange(r, j, r.length);
					break;
				}
			}

			total += validL.length;
			total += validR.length;

			if (validL.length > 0) {
				total += run(validL, validR);
			}
			if (validR.length > 0) {
				total += run(validR, validL);
			}
		}

		int result = (int) (total % 1000000007);

		return result;
	}

	private static long run(int[] validL, int[] validR) {
		long total = 0;

		// for each element in left array
		for (int j = 0; j < validL.length; j++) {

			int top = validL[j];

			int pointerL = j + 1;
			int pointerR = 0;

			boolean continueFinding = false;

			while (true) {
				// find bigger element in right array
				continueFinding = false;
				for (int j2 = pointerR; j2 < validR.length; j2++) {
					if (validR[j2] > top) {
						top = validR[j2];
						pointerR = j2;
						continueFinding = true;
						total++;
						break;
					}
				}

				if (!continueFinding) {
					break;
				}

				continueFinding = false;

				// find bigger element in the left array
				for (int j2 = pointerL; j2 < validL.length; j2++) {
					if (validL[j2] > top) {
						top = validL[j2];
						pointerL = j2;
						continueFinding = true;
						total++;
						break;
					}
				}

				if (!continueFinding) {
					break;
				}

			}
		}
		return total;
	}
}