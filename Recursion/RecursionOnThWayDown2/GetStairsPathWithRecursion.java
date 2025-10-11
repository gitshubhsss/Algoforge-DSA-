import java.util.ArrayList;

//T(n)=T(n-1)+T(n-2)+T(n2)
public class GetStairsPathWithRecursion {

    // todo function to get all the paths to climb the stairs you can take only
    // 1,2,3 steps at a time
    public static ArrayList<String> getAllStairsPath(int n) {
        if (n < 0) {
            // invalid state return []
            ArrayList<String> baseAns = new ArrayList<>();
            return baseAns;
        }
        if (n == 0) {
            // invalid state
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");// [""]
            return baseAns;
        }

        ArrayList<String> pathAfterOneStep = getAllStairsPath(n - 1);// 5
        ArrayList<String> pathAfterTwoStep = getAllStairsPath(n - 2);// 4
        ArrayList<String> pathAfterThreeStep = getAllStairsPath(n - 3);// 3

        ArrayList<String> myAns = new ArrayList<>();

        for (String s : pathAfterOneStep) {
            myAns.add("1" + s);
        }
        for (String s : pathAfterTwoStep) {
            myAns.add("2" + s);
        }
        for (String s : pathAfterThreeStep) {
            myAns.add("3" + s);
        }

        System.out.println("returning the path for " + n + " as " + myAns);
        return myAns;

    }

    public static void main(String[] args) {
        System.out.println(getAllStairsPath(4));

    }
}
