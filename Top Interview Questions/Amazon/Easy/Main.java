import java.util.HashMap;

public class Main {

    // Remove duplicates from sorted array using hashmap

    public static void removeDuplicates1(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) == false) {
                map.put(arr[i], 1);
            } else {
                int olderValue = map.get(arr[i]);
                map.put(arr[i], olderValue + 1);
            }
        }

    }

    // Remove duplicates from the array using 2 pointers
    // 0, 1, 1, 1, 2, 2, 3

    public static void removeDuplicates2(int[] arr) {

        int n = arr.length;
        int i = 0;
        int j = 1;

        while (i < n && j < n) {

            if (arr[i] == arr[j]) {

            } else if (arr[i] < arr[j]) {

            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 1, 2, 2, 3 };
        removeDuplicates1(arr);
    }
}
