package inheritance;

interface vehicle {
  int getNumberOfWheels();
}


abstract class Car implements vehicle {
  public int getNumberOfWheels() {
    return 4;
  }
}


public class Test1 extends Car {

  public static void main(String[] args) {
    Car puma = new Test1();
    System.out.println(puma.getNumberOfWheels());
  }

  // cannot restrict the access
  @Override
  public int getNumberOfWheels() {
    // TODO Auto-generated method stub
    return super.getNumberOfWheels();
  }

}
