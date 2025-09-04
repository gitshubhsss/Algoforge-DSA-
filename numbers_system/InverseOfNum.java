import java.util.Scanner;

public class InverseOfNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        int number = sc.nextInt();
        // Initial position
        int x = 1;

        int inversedNumber = 0;

        while (number > 0) {
            // Keep finding the last digit

            int positionYouWantKeepTheNumber = number % 10;

            int p = positionYouWantKeepTheNumber;

            inversedNumber = inversedNumber + x * (int) Math.pow(10, p - 1);

            //increasing the position
            x++;

            number = number / 10;
        }

        System.out.println(inversedNumber);
    }
}