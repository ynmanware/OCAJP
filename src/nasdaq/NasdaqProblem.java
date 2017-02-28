package nasdaq;

import java.math.BigInteger;

/*
 * You have a range of consecutive numbers, from 1 to n (inclusive). e.g. [1,2,3,4,...,n].
We would like to calculate a sum of a function across the entire range, where the function returns the product of the *preceding* C elements.
If there are less than C previous elements, just use the available numbers. i.e. if you are processing the fourth number in the range, 
but C is greater than 3, then you will calculate the product using only the 3 available preceding numbers. 
* In this situation as you move further along in this range more preceding numbers become available.
A worked example follows: if n=5 and C=2, the correct products and final sum for each element of the range are: 0 + 1 + 2 + 6 + 12 = 21
The solution should be implemented in Java. Initially calculate the value where n=100 and C=10, and let us know the answer
Please additionally tell us the values where n=1000000 and C=200, but only include the first 10 digits of the result in your answer.
What is the algorithmic complexity of your solution? What if you needed to calculate n=10,000,000 and C=200 ?

 */

public class NasdaqProblem {

	public static void main(String[] args) {

		solution(5, 2); // Result is 21
		solution(100, 10); // Result is 5139462350
		solution(1000000, 200); // Result is 4876116127
		solution(10000000, 200); // Result is 4965134354

	}

	/**
	 * The time complexity is (O(n - c) * O(n^2)) + O(n^2.585)
	 * 
	 * @param n
	 * @param c
	 * @return
	 */
	private static long solution(int n, int c) {

		if (n < 0 || c < 0) {
			throw new IllegalArgumentException();
		}

		BigInteger sum = BigInteger.valueOf(0);
		BigInteger product = BigInteger.valueOf(1);

		for (int i = 1; i < n; i++) {
			if (i > c) {
				// Knuth algo O(n^2)
				product = product.divide(BigInteger.valueOf(i - c));
			}
			
			// between Toom-Cook Multiplication - O(n^1.465) to Karatsuba Multiplication - O(n^1.585)
			product = product.multiply(BigInteger.valueOf(i));

			sum = sum.add(product);
		}

		String resultStr = sum.toString();

		if (resultStr.length() > 10) {
			resultStr = resultStr.substring(0, 10);
		}

		Long r = Long.valueOf(resultStr);

		System.out.format("For n: %d and c: %d, Result is %d", n, c, r);
		System.out.println();

		return r;
	}

}
