import java.util.ArrayList;

public class ClimbStairsRecursion {

    // the user can take only 1,2,3 steps at a time
    // we need to return the number of possible steps that the user can take to
    // reach to destination

    // n=4
    // 1111,112,121,211,13,31,

    // n==3
    // 111,12,21,3

    // n==2
    // 11,2

    // n==1
    // 1

    // if you observe if we solve the problme from the big our job is jus to add the
    // n
    public static ArrayList<String> climbStairs(int n) {
        if (n < 0) {
            ArrayList<String> baseArray = new ArrayList<>();
            return baseArray;
        }
        if (n == 0) {
            ArrayList<String> baseArray = new ArrayList<>();
            baseArray.add("");
            return baseArray;
        }

        ArrayList<String> climbOneStepAtaTime = climbStairs(n - 1);
        ArrayList<String> climbTwoStepsAtaTime = climbStairs(n - 2);
        ArrayList<String> climbThreeStepsAtaTime = climbStairs(n - 3);

        ArrayList<String> myAns = new ArrayList<>();

        for (String s : climbOneStepAtaTime) {
            myAns.add("1" + s);
        }

        for (String s : climbTwoStepsAtaTime) {
            myAns.add("2" + s);
        }
        for (String s : climbThreeStepsAtaTime) {
            myAns.add("3" + s);
        }
        return myAns;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
