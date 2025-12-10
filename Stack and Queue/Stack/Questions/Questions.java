package Stack.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Questions {

    // String exp = "((a+B)+((a+c))";
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
                // if their is hte openig brackets will push them
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
                    // onnce we got the element store it in the ArrayList and and make the
                    // hasRightGreater =true and break the loop

                    ans.add(arr[j]);
                    hasRightGreater = true;
                    break;
                }

            }
            // if no element greater in the right add -1
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

    public ArrayList<Integer> nextLargerElementWithOutArray(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> ans = new ArrayList<Integer>();

        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {

            int currEle = arr[i];

            while (stack.size() > 0 && stack.peek() <= currEle) {
                stack.pop();
            }

            if (stack.size() == 0) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }
            stack.push(arr[i]);
        }

        Collections.reverse(ans);
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

    // ========================>O(N^2);
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> ansList = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        int n = arr.length;

        int ans[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int curr = arr[i];

            while (stack.size() > 0 && stack.peek() <= curr) {
                count++;// 2//3//4
                stack.pop();
            }

            ans[i] = count;
            while (!stack.isEmpty()) {
                stack.pop();
            }
            fillStack(stack, 0, i, arr);
        }

        for (int i = 0; i < ans.length; i++) {
            ansList.add(ans[i]);
        }

        return ansList;
    }

    public void fillStack(Stack<Integer> stack, int s, int e, int arr[]) {
        while (s <= e) {
            stack.push(arr[s]);
            s++;
        }
    }

    // push at the bottom of the stack

    public static String reverseString(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.push(ch);
        }
        // create the String builder

        StringBuilder ans = new StringBuilder("");

        while (!stack.isEmpty()) {
            char ch = stack.pop();
            ans.append(ch);
        }

        return ans.toString();
    }

    public static void pushAtBottom(Stack<Integer> st, int ele) {
        if (st.isEmpty()) {
            st.push(ele);
            return;
        }
        int num = st.peek();
        st.pop();
        pushAtBottom(st, ele);
        st.push(num);
    }

    public static void reverseStack(Stack<Integer> st) {

        if (st.empty()) {
            return;
        }

        int ele = st.pop();// 3//2//1
        reverseStack(st);
        pushAtBottom(st, ele);

    }

    // 17700-->842
    public static void main(String[] args) {

        String exp = "((a+B)+((a+c))";

        // System.out.println(isDuplicate(exp));

        int arr[] = { 15, 10, 20, 12, 17, 18, 10, 9, 8, 39, 11 };

        // System.out.println(nextLargerElementRightToLeft(arr));
        // System.out.println(nextLargerElementLeftToRight(arr));

        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        // pushAtBottom(st, 4);

        // System.out.println(st);

        reverseStack(st);
        System.out.println(st);

    }
}
