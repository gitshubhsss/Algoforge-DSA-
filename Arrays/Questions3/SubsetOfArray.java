public class SubsetOfArray {

    public static int convertNumberToBinary(int num) {
        int binary = 0;
        int pow = 0;
        while (num > 0) {
            // find the remender after deviding it with 0
            int last = num % 2;
            binary = binary + (int) Math.pow(10, pow) * last;
            num = num / 2;
            pow++;
        }
        return binary;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 11, 19 };
        int totalNumberOfSubsets = (int) Math.pow(2, arr.length);
        int set = 0;
        // while (set < totalNumberOfSubsets) {
        // int binaryIndex = convertNumberToBinary(set);
        // int i = 0;
        // while (binaryIndex > 0) {
        // int last = binaryIndex % 10;
        // if (last == 1) {
        // System.out.print(arr[i] + " ");
        // }
        // binaryIndex = binaryIndex / 10;
        // i++;
        // }
        // System.out.println();
        // set++;
        // }
        // total subsets 8
        while (set < totalNumberOfSubsets) {
            int currentSet = set;// 0,1,2
            String subset = " ";
            // Going on each element each element will have two options
            //2,1
            for (int i = arr.length - 1; i >= 0; i--) {
                int rem = currentSet % 2;//0
                if (rem == 0) {
                    subset = subset + "_,";
                } else {
                    subset = subset + arr[i] + ",";
                }
                currentSet = currentSet / 2;
            }
            System.out.println(subset);
            set++;

        }
    }
}
// -,-,-  0
//19,_,_, 1
//_,11,_  2 



