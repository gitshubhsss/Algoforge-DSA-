import java.util.*;

public class HashFunction {

  private int findBucketIndex(K key) {
    int hc = key.hashCode(); // -16 || 5;
    int bucketIndex = Math.abs(hc) % number_of_buckets;

    return bucketIndex;
  }

  public static void main(String args[]) {
    K key = new Key();

    
    System.out.println(findBucketIndex("shubham"));
  }
}
