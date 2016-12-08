package functional_interfaces;

import java.util.function.BiPredicate;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class TestBiPredicate {

  public static void main(String[] args) {

    String s1 = "Yogesh";
    BiPredicate<String, String> mbp = String::startsWith;
    BiPredicate<String, String> lbp = (str, prefix) -> str.startsWith(prefix);

    System.out.println(lbp.test("Yogesh", "Y"));
    System.out.println(lbp.test("Yogesh", "N"));

  }
}
