public class FindAllIndexesOfTarEle {

    public static int[] findIndexes(int arr[], int target, int idx, int csf) {

        // base case here will return the base array having 0 values
        if (idx == arr.length) {
            int baseArrayWithZeroValues[] = new int[csf];
            return baseArrayWithZeroValues;
        }

        // faith:it will work properly for the smaller value the smaller value is
        // idx+1 to n-1;
        // so will try to find the lenth of the output array we have the variable called
        // csf that is 0 initailly as soon as we get the arr[idx]==target then will
        // increase count
        // otherwise will pass the same csf
        int ans[];
        if (arr[idx] == target) {
            // element fount
            ans = findIndexes(arr, target, idx + 1, csf + 1);
        } else {
            ans = findIndexes(arr, target, idx + 1, csf);
        }
        // fill the values in the array
        if (arr[idx] == target) {
            ans[csf] = idx;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 19, 4, 3, 5, 4, 4, 6, 8 };
        int target = 4;
        int csf = 0;

        int indexArray[] = findIndexes(arr, target, 0, csf);

        for (int i = 0; i < indexArray.length; i++) {
            System.out.println(indexArray[i]);
        }

    }
}

// 0
// 2
// 5
// 6
