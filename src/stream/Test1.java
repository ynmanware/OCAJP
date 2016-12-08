package stream;

import java.util.stream.Stream;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class Test1 {

  public static void main(String[] args) {
    Stream<Double> randoms = Stream.generate(Math::random);
    randoms.forEach(System.out::println);
    Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
    oddNumbers.forEach(System.out::println);
  }
}
