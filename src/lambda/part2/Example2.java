package lambda.part2;

import java.util.Comparator;

public class Example2 {

	public static void main(String[] args) {

		// with parameter's type
		Comparator<String> c1 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

		// without parameter's type
		Comparator<String> c12 = (s1, s2) -> Integer.compare(s1.length(), s2.length());

		// if we are just passing the parameters to other method
		Comparator<Integer> c3 = (i1, i2) -> Integer.compare(i1, i2);

		// can be written as
		Comparator<Integer> c31 = Integer::compare;

	}
}
