import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();
        int n = nums.length;
        int total_number_of_subsets = (int) Math.pow(2, n);

        int set = 0;
        while (set < total_number_of_subsets) {
            int currentset = set;
            List<Integer> currentSets = new ArrayList<>();
            for (int idx = n - 1; idx >= 0; idx--) {
                int rem = currentset % 2;// find the last binary digit
                // if the last binary digit is 1 add the element in the array
                if (rem == 1) {
                    currentSets.add(nums[idx]);
                }
            }
            setsList.add(currentSets);
            set++;
        }

        return setsList;
    }

    public static void main(String[] args) {

    }
}
