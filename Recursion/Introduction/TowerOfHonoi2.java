public class TowerOfHonoi2 {

    // Expectations -: it will print the steps to move the nth disk from A to C
    public static void towerOfHonai(int n, int A, int B, int C) {

        // Solve for the small problem
        if (n == 0) {
            return;
        }

        // A to B using C
        towerOfHonai(n - 1, A, C, B);// it will print the steps to move the n-1 disk from A TO B using C
        // Solve the whole problem
        System.out.println("moving the disk " + n + " from " + A + " to " + C);

        // B to C using A
        towerOfHonai(n - 1, B, A, C);

    }

    public static void main(String[] args) {
        towerOfHonai(3, 10, 20, 30);
    }
}

/*
 * moving the disk 1 from 10 to 30
 * moving the disk 2 from 10 to 20
 * moving the disk 1 from 30 to 20
 * moving the disk 3 from 10 to 30
 * moving the disk 1 from 20 to 10
 * moving the disk 2 from 20 to 30
 * moving the disk 1 from 10 to 30
 */
