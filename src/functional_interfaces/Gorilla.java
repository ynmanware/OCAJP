package functional_interfaces;

interface Gorilla {
  String move();
}


class GorillaFamily {


  public static void main(String[] args) {
    GorillaFamily gf = new GorillaFamily();
    gf.everyonePlay(true);
  }

  String walk = "walk";

  void everyonePlay(boolean baby) {
    String approach = "amble";

    // approach = "run";
    play(() -> walk);
    play(() -> baby ? "hitch a ride" : "run");
    play(() -> approach);
  }

  void play(Gorilla g) {
    System.out.println(g.move());
  }
}
