import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

  static class HashMap<K, V> {

    class HashMapNode {

      K key;
      V value;

      HashMapNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private LinkedList<HashMapNode>[] buckets;
    private int size;
    private int number_of_buckets = 4;

    //create the construction of the HashMap

    HashMap() {
      size = 0;

      initializeBuckets();
    }

    private int findBucketIndex(K key) {
      int hc = key.hashCode(); //-23||23

      int bucketIndex = Math.abs(hc) % number_of_buckets;

      return bucketIndex;
    }

    private int findKeyIndex(K key, int bucketIndex) {
      int keyIndex = 0;

      for (HashMapNode node : buckets[bucketIndex]) {
        if (node.key.equals(key)) {
          return keyIndex;
        }
        keyIndex++;
      }

      return -1;
    }

    //function to initailzie the buckets

    private void initializeBuckets() {
      buckets = new LinkedList[number_of_buckets];

      System.out.println("Initialize the buckets" + number_of_buckets);

      for (int i = 0; i < buckets.length; i++) {
        buckets[i] = new LinkedList<>();
      }
    }

    public void put(K key, V value) {
      int bucketIndex = findBucketIndex(key);
      int keyIndex = findKeyIndex(key, bucketIndex);

      if (keyIndex == -1) {
        ///No such key in our hashmap
        HashMapNode newNode = new HashMapNode(key, value);
        buckets[bucketIndex].add(newNode);
        this.size++;
      } else {
        //updaste existing key value
        HashMapNode node = buckets[bucketIndex].get(keyIndex);
        node.value = value;
      }

      ///check if you want to rehash
      double lambda = (this.size * 0.1) / number_of_buckets;
      if (lambda >= 2.0) {
        rehash();
      }
    }

    private void rehash() {
      this.size = 0;
      number_of_buckets = number_of_buckets * 2;
      //save the old data
      LinkedList<HashMapNode>[] oldBuckets = buckets;

      //create the new data
      LinkedList<HashMapNode>[] newBuckets = new LinkedList[number_of_buckets];

      //buckets should be refering to the new data
      this.buckets = newBuckets;
      initializeBuckets();

      for (int i = 0; i < oldBuckets.length; i++) {
        for (HashMapNode node : oldBuckets[i]) {
          this.put(node.key, node.value);
        }
      }
    }

    public V get(K key) {
      int bucketIndex = findBucketIndex(key);
      int keyIndex = findKeyIndex(key, bucketIndex);

      if (keyIndex == -1) {
        return null;
      } else {
        HashMapNode node = buckets[bucketIndex].get(keyIndex);
        return node.value;
      }
    }

    public boolean containsKey(K key) {
      int bucketIndex = findBucketIndex(key);
      int keyIndex = findKeyIndex(key, bucketIndex);

      if (keyIndex != -1) {
        return true;
      }

      return false;
    }

    public V remove(K key) {
      int bucketIndex = findBucketIndex(key);
      int keyIndex = findKeyIndex(key, bucketIndex);

      if (keyIndex != -1) {
        HashMapNode node = buckets[bucketIndex].remove(keyIndex);
        return node.value;
      }

      return null;
    }

    public ArrayList<K> keySet() {
      ArrayList<K> keys = new ArrayList<>();

      for (int i = 0; i < buckets.length; i++) {
        for (HashMapNode node : buckets[i]) {
          keys.add(node.key);
        }
      }

      return keys;
    }
  }

  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();

    map.put("shubham", 500);
    map.put("pavan", 400);
    map.put("ashish", 1230);
    map.put("omkar", 70);
    map.put("krishna", 70);
    map.put("dashwadkar", 70);
    map.put("tejas", 70);
    map.put("vision", 70);
    map.put("narzo", 70);
    map.put("androbuddy", 70);
    map.put("technlogy", 70);
    map.put("methodology", 70);
    map.put("sinhgad", 70);
    map.put("raghunath", 70);
    map.put("anna", 70);
    map.put("vada", 70);
    map.put("pav", 70);
    map.put("misal", 70);
    map.put("sdf", 70);
    map.put("ds", 70);
    map.put("dss", 70);
    map.put("dssf", 70);
    map.put("dssfsf", 70);
    map.put("dssfsfsf", 70);

    System.out.println(map.get("shubham"));
    map.put("shubham", 7);
    System.out.println(map.get("shubham"));
    map.remove("shubham");
    System.out.println(map.get("shubham"));
    System.out.println(map.containsKey("shubham"));

    System.out.println(map.keySet());
  }
}
