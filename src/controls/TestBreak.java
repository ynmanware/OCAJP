package controls;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class TestBreak {
  public static void main(String[] args) {
    int x = 5, j = 0;

    OUTER: for (int i = 0; i < 3;)

      INNER: do {
        i++;
        x++;
        if (x > 10)
          break INNER; // starts the loop again, does not print at line 23
        x += 4;
        j++;
      } while (j <= 2);
    System.out.println(x);
  }
}
