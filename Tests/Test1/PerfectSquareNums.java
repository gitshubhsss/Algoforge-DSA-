package Tests.Test1;

import java.util.Scanner;

public class PerfectSquareNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        // int num = 1;
        int count = 0;
        int ans = 0;// 1,4,9,16,25

        // TODO My aaproach
        // while (ans <= n) {
        // ans = (int) Math.pow(num, 2);//4,9,16,25,36
        // num++;//2,3,4,5,6,7
        // count++;//2,3,4,5,6
        // }
        // System.out.println(count);
        // Omkars aproach
        for (int i = 1; i <= n; i++) {
            ans = (int) Math.pow(i, 2);
            if (ans <= n) {
                count++;// 1,2,3,4,5
            } else {
                break;
            }
            System.out.println(i);
        }
        System.out.println(count);
        sc.close();
    }
}
