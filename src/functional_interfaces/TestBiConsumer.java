package functional_interfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 *
 * @Author Yogesh.Manware
 *
 */

public class TestBiConsumer {

  public static void main(String[] args) {

    Map<String, String> map = new HashMap<String, String>();

    BiConsumer<String, String> mbc = map::put;

    BiConsumer<String, String> lbc = (k, v) -> {
      System.out.println("Element Added!");
      map.put(k, v + "d");
    };

    lbc.accept("Y", "K");

    System.out.println(map);


  }

}
