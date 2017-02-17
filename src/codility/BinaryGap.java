package codility;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(solutionLoop(9));
	}

	static int solutionLoop(int n) {
		int current = 0;
		int max = 0;
		while (n > 0) {
			if (n % 2 == 0)
				++current;
			else {
				max = Math.max(max, current);
				current = 0;
			}
			n /= 2;
		}
		return max;
	}
}