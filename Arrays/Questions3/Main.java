public class Main {

    public static void convertNumberToBinary(int num) {
        int binary = 0;
        int pow = 0;
        while (num > 0) {
            int rem = num % 2;
            binary = binary + (int) Math.pow(10, pow) * rem;
            num = num / 2;
            pow++;
        }
        System.out.println(binary);
    }

    public static void main(String args[]) {

        convertNumberToBinary(11 );
        // int[] arr = { 1, 3, -2, 4, -3, -8, 9, -3, 13 };

        // N^3
        // while (si < arr.length) {
        // // going from si to end
        // for (int i = si; i < arr.length; i++) {
        // // si se leke end tak sum nikalo
        // int sum = 0;
        // for (int k = si; k <= i; k++) {
        // sum = sum + arr[k];
        // }
        // max = Math.max(max, sum);
        // }
        // si++;
        // }
        // System.out.println(max);
        // N^2
        // int[] arr = {9,-5,-4,10,11};
        // int ansSI = -1;
        // int andEI = -1;
        // while (si < arr.length) {
        // int currSum = 0;// 0,
        // // si=0,1
        // for (int ei = si; ei < arr.length; ei++) {
        // // ei=0,1,2,3
        // // ei=1,2,3,4
        // currSum = currSum + arr[ei];// -5,-9,1

        // if (max < currSum) {
        // ansSI = si;// 0
        // andEI = ei;// 4
        // max = currSum;// 9,10,21
        // }

        // }
        // si++;
        // }
        // System.out.println(max);
        // System.out.println(ansSI);
        // System.out.println(andEI);

        // kandance

        // int maxSum = Integer.MIN_VALUE;// minus infinity
        // int currentSum = 0;
        // int curr_SI = 0;// starting index of the range beetwenn max sum
        // int maxSI = -1;
        // int maxEI = -1;
        // int si = 0;
        // // int arr[]={1,3,-2,4,-3,-8,9,-3,10,-21,1,3}
        // while (si < arr.length) {
        // // si=0,1,2,3,4,5,6
        // currentSum = currentSum + arr[si];//1,4,2,6,3,-5,9

        // if (maxSum < currentSum) {
        // maxSI = curr_SI;//0//6
        // maxEI = si;// 0,1,3
        // maxSum = currentSum;//1,4,6
        // }

        // if (currentSum < 0) {
        // currentSum = 0;
        // curr_SI = si + 1;

        // }
        // si++;
        // }
        // System.out.println(maxSum);
        // System.out.println(maxSI);
        // System.out.println(maxEI);

    }
}