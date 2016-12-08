package functional_interfaces;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class TestSupplier {

  public static void main(String[] args) {

    Supplier<LocalDate> ms = LocalDate::now;
    Supplier<LocalDate> ls = () -> LocalDate.now();

    LocalDate ms1 = ms.get();
    LocalDate ls1 = ls.get();

    System.out.println(ms1);
    System.out.println(ls1);

    Supplier<StringBuilder> ss = StringBuilder::new;
    Supplier<StringBuilder> s1 = () -> new StringBuilder();

    System.err.println(ss);

  }
}
