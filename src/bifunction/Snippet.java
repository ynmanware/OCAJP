package bifunction;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Snippet {
  public static void main(String[] args) {

    // computeIfPresent();
    testMerge();

  }

  static void testMerge() {
    Map<String, Integer> counts = new HashMap<>();
    counts.put("Jenny", 2);
    counts.put("Tom", 5);

    BiFunction<Integer, Integer, Integer> mapper = (v1, v2) -> v1 > v2 ? v1 : v2;
    Integer jenny = counts.merge("Jenny", 14, mapper);
    System.out.println(counts.get("Jenny")); // {Jenny=2}
  }

  static void computeIfPresent() {
    Map<String, Integer> counts = new HashMap<>();
    counts.put("Jenny", 2);
    BiFunction<String, Integer, Integer> mapper = (K, V) -> V * 5;
    Integer jenny = counts.computeIfPresent("Jenny", mapper);
    Integer sam = counts.computeIfPresent("Sam", mapper);
    System.out.println(counts); // {Jenny=2}
    System.out.println(jenny); // 2
    System.out.println(sam); // null

  }
}

/**
 *
 * @Author Yogesh.Manware
 *
 */


