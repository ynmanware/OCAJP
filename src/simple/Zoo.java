package simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Zoo {
	public static void main(String[] args) {

		System.out.println(isAnagram("java", "avaj"));
		System.out.println(isAnagram("java", "avaje"));
	}

	// find duplicate string
	public static char findDuplicate(String str) {

		int i = 0;
		Set<Character> map = new HashSet<>();

		while (i < str.length()) {
			char c = str.charAt(i++);
			if (map.contains(c)) {
				return c;
			}
			map.add(c);
		}

		return '\u0000';
	}

	public static boolean isAnagram(String str, String str2) {

		char[] cs = str.toCharArray();
		char[] cs2 = str2.toCharArray();
		Arrays.sort(cs);
		Arrays.sort(cs2);

		return Arrays.equals(cs, cs2);
	}
	


}