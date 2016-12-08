package inheritance;


public class InterfaceTest {

  public static void main(String[] args) {
    /*
     * OtterImpl1 ot = new OtterImpl1(); System.out.println("Name: " + ot.getName());
     */

    OtterImpl2 ot2 = new OtterImpl2();
    System.out.println("Name2: " + ot2.getName());
  }
}


abstract interface Animal {
  public default String getName() {
    // always this interface method is invoked
    bark();
    return "Animal";
  }


  static void bark() {
    System.out.println("Animal Bark ");
  }
}


interface Mammal {
  public default String getName() {
    // note here implementation method is not invoked
    bark();
    return "Mamal";
  }

  static void bark() {
    System.out.println("mamal Bark ");
  }
}


abstract class Otter implements Mammal, Animal {
  @Override
  public abstract String getName();
}


class OtterImpl1 extends Otter {

  @Override
  public String getName() {
    return "Otto1";
  }

}
