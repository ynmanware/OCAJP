package methodoverriding;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class Test2 {
  public static void main(String[] args) {
    Giraffe Giraffe = new ReinGiraffe(5);
    System.out.println("," + Giraffe.hasHorns());
  }
}

