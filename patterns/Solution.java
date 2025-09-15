import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 0;
        int temp = n;
        while (temp > 0) {
            temp = temp / 10;
            len++;
        }
        System.out.println(len);
        int sum = 0;
        while (n > 0) {
            int last = n % 10;
            if (len % 2 == 0) {
                sum = sum + last;
            }
            n = n / 10;
            len--;
        }
        System.out.println(sum);
        sc.close();
    }
    
}
