package method_references;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Snippet {

  Consumer<List<Integer>> methodRef1 = Collections::sort;
  Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);

  String str = "abc";
  Predicate<String> methodRef2 = str::startsWith;// two parameters are required
  Predicate<String> lambda2 = s -> str.startsWith(s);

  Predicate<String> methodRef3 = String::isEmpty; // just one parameter is required
  Predicate<String> lambda3 = s -> s.isEmpty();

  Supplier<ArrayList> methodRef4 = ArrayList::new;
  Supplier<ArrayList> lambda4 = () -> new ArrayList();


}

/**
 *
 * @Author Yogesh.Manware
 *
 */


