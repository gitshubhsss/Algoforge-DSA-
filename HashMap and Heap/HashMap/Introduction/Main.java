import java.util.*;

public class Main {

  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("India", 100);
    map.put("China", 90);
    map.put("USA", 50);

    if (map.containsKey("Inda")) {
      System.out.println(map.get("India"));
    }

    System.out.println(map);
  }
}
