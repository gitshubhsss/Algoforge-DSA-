public class RotateNumByK {

    public static int rotate(int n, int k) {

        // 1.find the length of the digit
        int length = 0;
        int temp = n;

        while (temp > 0) {
            temp = temp / 10;
            length++;
        }

        // finding the k with pattern
        k = k % length;
        if (k < 0) {
            k = k + length;
        }

        // finding the first digits
        int firstDigits = n / (int) Math.pow(10, length - k);
        // finding the last digits
        int lastDigits = n % (int) Math.pow(10, length - k);
        // ans
        int ans = lastDigits * (int) Math.pow(10, k) + firstDigits;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rotate(12345, 2));
    }
}