package Questions;
public class Inverse {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 1, 0, 2 };
        int n = arr.length;
        int[] inverseArray = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i];
            inverseArray[pos] = i;
        }
        printArray(inverseArray);

    }
}
