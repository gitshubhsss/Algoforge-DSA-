package basics;

public class TowerOfHonai {

    // A= from B=wia B , C=to that is our destination location
    public static void towerOfHanoi(int n, int A, int B, int C) {

        if (n <= 0) {
            return;
        }

        // if the whole problem is to move the disk from A to C using B
        // then the smaller problme will be to move the Disk from A to B using C

        towerOfHanoi(n - 1, A, C, B);
        System.out.println("Moving " + n + " th " + "disk form " + A + " to " + C);

        // Now move the disk from B to C using A

        towerOfHanoi(n - 1, B, A, C);
    }

    public static void main(String[] args) {

        towerOfHanoi(3, 10, 20, 30);
    }
}
