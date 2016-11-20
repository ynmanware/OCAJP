package controls;

public class TestSwitch {
  public static void main(String[] args) {

    int count = 0;
    int x = 3;
    // notice that the cound is incremented after condition check
    while (count++ < 3) {
      int y = (1 + 2 * count) % 3;
      switch (y) {
        default:
        case 0:
          x -= 1;
          break;
        case 1:
          x += 5;
      }
    }
    System.out.println(x);
  }
}
