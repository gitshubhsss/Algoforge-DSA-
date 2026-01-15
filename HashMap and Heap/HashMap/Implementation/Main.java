import java.util.LinkedList;

public class Main {

  Main() {
    System.out.println("Main constructor called");
  }

  class HashMap<K, V> {

    K key;
    V value;

    HashMap(K key, V value) {
      System.out.println("key is " + key + " value is " + value);
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String args[]) {
    Main m1 = new Main();

    m1.HashMap<String, String> hashMap = new HashMap<>();
  }
}
