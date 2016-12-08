package collections;

import java.util.ArrayList;
import java.util.List;

class Dragon
{
}

class Unicorn
{
}

public class LegacyDragons
{
   public static void main(String[] args)
   {
      List unicorns = new ArrayList();
      unicorns.add(new Unicorn());
      printDragons(unicorns);
      addSound(unicorns);
   }

   List< ? super Exception> l = new ArrayList<Throwable>();

   private static void printDragons(List<Dragon> dragons)
   {
      for (Dragon dragon : dragons)
      { // ClassCastException
         System.out.println(dragon);
      }
   }

   public static void addSound(List< ? super String> list)
   {
      list.add("quack");
   }
}