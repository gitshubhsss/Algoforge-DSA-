public class TowerOfHonai {

    public static void towerOfHonai(int n, int A, int C, int B) {
        if (n <= 0) {
            return;
        }
        towerOfHonai(n - 1, A, B, C);
        System.out.println("Moving " + n + " From " + A + " to " + C);
        towerOfHonai(n - 1, B, C, A);
        System.out.println("Moving " + n + " From " + B + " to " + C);
    }

    public static void main(String[] args) {
        towerOfHonai(3, 10, 30, 20);
    }
}
