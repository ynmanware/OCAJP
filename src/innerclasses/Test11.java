package innerclasses;

import innerclasses.Test1.A;


/**
 *
 * @Author Yogesh.Manware
 *
 */

public class Test11 {

  public static void main(String[] args) {

    Test1 t1 = new Test1();
    
    A df = t1.new A();
  }


}

