package Stack.Questions;

import java.util.ArrayList;
import java.util.Stack;

public class Questions {

    public static boolean isDuplicate(String exp) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (ch == ')') {

                // this means ( ) their is nothing inside this
                if (stack.peek() == '(') {
                    return true;
                }

                // pop everything till '('
                while (stack.peek() != '(') {
                    stack.pop();
                }

                stack.pop();// poping the opening bracket as well '('

            } else {
                stack.push(ch);
            }
        }

        return false;
    }

    /// LeetCode 20 Valid Parentheses

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == ')') {

                if (stack.size() == 0 || stack.peek() != '(') {
                    return false;
                }
                stack.pop();

            } else if (ch == ']') {

                if (stack.size() == 0 || stack.peek() != '[') {
                    return false;
                }

                stack.pop();

            } else if (ch == '}') {

                if (stack.size() == 0 || stack.peek() != '{') {
                    return false;
                }

                stack.pop();

            } else {
                stack.push(ch);
            }

        }

        if (stack.size() != 0) {// making sure every opening bracket had one closing bracket
            return false;
        }
        return true;

    }

    // https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
    public static ArrayList<Integer> nextLargerElementBruit(int[] arr) {// ==============?O(n^2)
        // code here

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            boolean hasRightGreater = false;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    ans.add(arr[j]);
                    hasRightGreater = true;
                    break;
                }

            }
            if (hasRightGreater == false) {
                ans.add(-1);
            }

        }

        return ans;

    }

    //// https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1

    public static ArrayList<Integer> nextLargerElementRightToLeft(int[] arr) {// right to left ====>method 1
        // code here
        ArrayList<Integer> ans = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        int n = arr.length;

        int ansArr[] = new int[n];

        int i = n - 1;

        while (i >= 0) {
            int currEle = arr[i];

            /// hadeling the size expection
            while (st.size() > 0 && st.peek() <= currEle) {
                st.pop();//
            }

            // if the stack size is empty
            if (st.size() == 0) {
                ansArr[i] = -1;

            } else {
                ansArr[i] = st.peek();
            }
            // every time push the curr Elemet
            st.push(currEle);
            i--;
        }

        for (int j = 0; j < n; j++) {
            ans.add(ansArr[j]);
        }

        return ans;

    }

    /// left to right apoch for the same problem
    public static ArrayList<Integer> nextLargerElementLeftToRight(int arr[]) {

        ArrayList<Integer> ansList = new ArrayList<>();

        int n = arr.length;

        int ans[] = new int[n];

        // initially feeling with -1
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currEle = arr[i];

            while (stack.size() > 0 && arr[stack.peek()] <= currEle) {
                ans[stack.peek()] = currEle;
                stack.pop();
            }
            stack.push(i);
        }

        for (int i = 0; i < ans.length; i++) {
            ansList.add(ans[i]);
        }

        return ansList;

    }

    public static void main(String[] args) {

        String exp = "((a+B)+((a+c))";

        // System.out.println(isDuplicate(exp));

        int arr[] = { 15, 10, 20, 12, 17, 18, 10, 9, 8, 39, 11 };

        System.out.println(nextLargerElementRightToLeft(arr));
        System.out.println(nextLargerElementLeftToRight(arr));
    }
}
