import java.util.HashMap;

public class Main {

  public static void main(String args[]) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("India", 91);
    map.put("China", 50);
    map.put("Pak", 92);

    System.out.println(map.get("Pak"));

    if (map.containsKey("India")) {
      System.out.println("India is present in the hashmap");
    }
    map.remove("India");
    System.out.println(map);
  }
}
