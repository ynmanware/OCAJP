package methodoverriding;

public class Giraffe {
  public Giraffe() {
    System.out.print("Giraffe");
  }

  public Giraffe(int age) {
    System.out.print("GiraffeAge");
  }

  boolean hasHorns() {
    return false;
  }

  public static void main(String[] args) {
    Giraffe Giraffe = new ReinGiraffe(5);
    System.out.println("," + Giraffe.hasHorns());
  }
}


class ReinGiraffe extends Giraffe {
  public ReinGiraffe(int age) {
    System.out.print("ReinGiraffe");
  }

  public boolean hasHorns() {
    return true;
  }
}
