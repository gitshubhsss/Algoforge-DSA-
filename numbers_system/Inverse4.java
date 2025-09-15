public class Inverse4 {
    public static void main(String[] args) {
        int number = 1342;
        int numLength = 0;
        int temp = number;
        while (temp > 0) {
            temp = temp / 10;
            numLength++;
        }

        int inverse = 0;
        int pow = numLength;
        while (number > 0) {
            int last = number % 10;
            inverse = inverse + (int) Math.pow(10, numLength - last) * pow;
            number = number / 10;
            pow--;
        }
        System.out.println(inverse);
    }
}
