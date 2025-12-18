package Stack.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Questions {

    public static boolean isDuplicateBracket(String ex) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < ex.length(); i++) {
            char ch = ex.charAt(i);

            if (ch == ')') {

                // If st.peek()==( then we have duplicate brackets
                if (st.peek() == '(') {
                    return true;
                }
                while (st.peek() != '(') {
                    st.pop();
                }
                st.pop();// popping ='(';
            } else {
                st.push(ch);
            }
        }

        return st.size() != 0;
    }

    // Leetcode 20

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0 || st.peek() != '(') {
                    return false;
                }

                st.pop();
            } else if (ch == ']') {
                if (st.size() == 0 || st.peek() != '[') {
                    return false;
                }

                st.pop();
            } else if (ch == '}') {
                if (st.size() == 0 || st.peek() != '{') {
                    return false;
                }

                st.pop();
            }
        }

        return st.size() == 0;

    }

    // next greater on right moving from right----> to left

    public static ArrayList<Integer> nextLargerElement(int arr[]) {

        int n = arr.length;

        int ngr[] = new int[n];// to store the ansers

        Stack<Integer> st = new Stack<>();

        st.push(-1);// intial value

        // traverse from n-1 to 0
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];

            // will keep only the bada wala element
            while (st.peek() != -1 && st.peek() <= curr) {
                st.pop();
            }

            ngr[i] = st.peek();
            // every time dont forget to push the element
            st.push(arr[i]);
        }

        // create the answer
        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < ngr.length; i++) {
            ansList.add(ngr[i]);
        }

        return ansList;
    }

    // next greater on right moving from left <-------- to right

    // [15,10,20,12,17,18,10,9,8,39,11]
    public static ArrayList<Integer> nextLargerElement2(int arr[]) {

        int n = arr.length;

        int ngr[] = new int[n];// to store the ansers

        for (int i = 0; i < ngr.length; i++) {
            ngr[i] = -1;// initializing it with -1
        }

        Stack<Integer> st = new Stack<>();

        // traverse from 0 to n

        for (int i = 0; i < n; i++) {

            int curr = arr[i];
            while (st.size() > 0 && arr[st.peek()] <= curr) {
                ngr[st.pop()] = curr;
            }
            st.push(i);// storing the indexes
        }

        // creating the answer

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < ngr.length; i++) {
            ans.add(ngr[i]);
        }

        return ans;

    }

    /// Homework 1 ===========Next greater left usign right to left

    public static ArrayList<Integer> nglUsingRL(int arr[]) {

        int n = arr.length;

        int ngl[] = new int[n];

        // fil the values with -1
        for (int i = 0; i < n; i++) {
            ngl[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        // traverse it from the right to left

        for (int i = n - 1; i >= 0; i--) {

            int curr = arr[i];

            while (st.size() > 0 && arr[st.peek()] < curr) {
                ngl[st.pop()] = curr;
            }

            st.push(i);

        }

        // create the answer

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < ngl.length; i++) {
            ans.add(ngl[i]);
        }

        return ans;
    }

    /// Homework 2 ===========Next greater left usign left to right

    public static ArrayList<Integer> nglUsingLR(int arr[]) {

        int n = arr.length;

        int ngl[] = new int[n];

        for (int i = 0; i < n; i++) {
            ngl[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        // traverse from 0 to n

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            while (st.size() > 0 && arr[st.peek()] < curr) {
                st.pop();
            }

            if (st.size() > 0) {
                ngl[i] = arr[st.peek()];
            }
            st.push(i);
        }

        // create the answer

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(ngl[i]);
        }

        return ans;
    }

    // https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        st.push(-1);

        int ngl[] = new int[n];// find the next greater on left

        for (int i = 0; i < n; i++) {

            int curr = arr[i];

            while (st.peek() != -1 && arr[st.peek()] <= curr) {
                st.pop();
            }

            ngl[i] = i - st.peek();
            st.push(i);
        }

        // create the answer

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < ngl.length; i++) {
            ans.add(ngl[i]);
        }

        return ans;
    }

    /// https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1
    /// LEFT TO RIGHT
    public static int[] leftSmallerLR(int[] arr) {
        // code here

        int n = arr.length;
        int nsl[] = new int[n];

        Stack<Integer> st = new Stack<>();

        st.push(-1);

        for (int i = 0; i < n; i++) {

            int curr = arr[i];

            while (st.peek() != -1 && st.peek() >= curr) {
                st.pop();
            }

            nsl[i] = st.peek();

            st.push(curr);
        }

        return nsl;
    }

    /// https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1
    /// RIGHT TO LEFT
    public int[] leftSmallerRL(int[] arr) {
        // code here

        int n = arr.length;
        int nsl[] = new int[n];

        // fill the array

        for (int i = 0; i < n; i++) {
            nsl[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            int curr = arr[i];

            while (st.size() > 0 && arr[st.peek()] > curr) {

                nsl[st.pop()] = curr;
            }

            st.push(i);
        }

        return nsl;
    }

    // https://www.geeksforgeeks.org/dsa/next-smaller-element/

    // Input: arr[] = [4, 8, 5, 2, 25]
    // Output: [2, 5, 2, -1, -1]

    // LEFT TO RIGHT

    public static ArrayList<Integer> nextSmallerEleOnRight(int[] arr) {

        int n = arr.length;
        // finding the next smaller right
        int nsr[] = new int[n];

        // fill the array

        for (int i = 0; i < n; i++) {
            nsr[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            int curr = arr[i];

            while (st.size() > 0 && arr[st.peek()] > curr) {
                nsr[st.pop()] = curr;
            }

            st.push(i);
        }

        // create the answer list

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(nsr[i]);
        }

        return ans;

    }

    // https://www.geeksforgeeks.org/dsa/next-smaller-element/

    // Input: arr[] = [4, 8, 5, 2, 25]
    // Output: [2, 5, 2, -1, -1]

    // RIGHT TO LEFT

    public static ArrayList<Integer> nextSmallerEleOnRight2(int[] arr) {

        int n = arr.length;
        // finding the next smaller right
        int nsr[] = new int[n];

        // fill the array

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = n - 1; i >= 0; i--) {

            int curr = arr[i];

            while (st.peek() != -1 && st.peek() > curr) {
                st.pop();
            }

            nsr[i] = st.peek();

            st.push(curr);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans.add(nsr[i]);
        }

        return ans;

    }

    /// Leetcode 84. Largest
    /// (https://leetcode.com/problems/largest-rectangle-in-histogram/)

    public static int largestRectangleAreaWithoutOptimized(int[] heights) {

        int n = heights.length;

        // store the next smaller left

        int nsl[] = new int[n];

        // fill the array with the -1

        for (int i = 0; i < n; i++) {
            nsl[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        st.push(-1);

        /// find the next smaller on left
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            while (st.peek() != -1 && heights[st.peek()] > curr) {
                st.pop();
            }
            nsl[i] = st.peek();
            st.push(i);
        }

        // empty the stack
        st = new Stack<>();

        // create the next smaller on right array
        int nsr[] = new int[n];

        // fill the array with n
        for (int i = 0; i < n; i++) {
            nsr[i] = n;
        }

        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            while (st.size() > 0 && heights[st.peek()] > curr) {
                nsr[st.pop()] = i;
            }
            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nsr[i] - nsl[i] - 1;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    /// ===========================================================84. Largest
    /// Rectangle in Histogram

    // [8, 2, 3, 1, 5, 6, 5, 4, 3, 6]
    public static int largestRectangleArea(int heights[]) {

        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        st.push(-1);

        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            while (st.peek() != -1 && heights[st.peek()] > curr) {
                int height = heights[st.pop()];
                int nsl = st.peek();
                int nsr = i;
                maxHeight = Math.max(maxHeight, height * (nsr - nsl - 1));

            }
            st.push(i);
        }

        while (st.peek() != -1) {
            int height = heights[st.pop()];
            int nsl = st.peek();
            int nsr = n;
            maxHeight = Math.max(maxHeight, height * (nsr - nsl - 1));
        }

        return maxHeight;
    }

    // ===========>Homework=======================>
    // https://leetcode.com/problems/maximal-rectangle/description/

    /// ===========================Questions ON POSTFIX INFIX PREFIX
    /// EXPRESSION===========================================

    public static int checkPrecedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static int evalute(char op, int val1, int val2) {

        if (op == '+') {
            return val1 + val2;
        } else if (op == '-') {
            return val2 - val1;
        } else if (op == '*') {
            return val1 * val2;
        } else if (op == '/') {
            return val1 / val2;
        }
        return -1;
    }

    // 2+3*5-8+(4/7+5)*9
    public static int evaluateExpression(String expression) {

        int n = expression.length();

        Stack<Integer> operands = new Stack<>();

        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);

            if (ch == ')') {

                while (operators.peek() != '(') {
                    char op = operators.pop();

                    int ans = evalute(op, operands.pop(), operands.pop());
                    operands.push(ans);
                }
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (operators.size() > 0 && checkPrecedence(operators.peek()) >= checkPrecedence(ch)) {

                    char op = operators.pop();

                    int ans = evalute(op, operands.pop(), operands.pop());

                    System.out.println(ans);

                    operands.push(ans);
                }

                operators.push(ch);

            } else if (ch == '(') {

                operators.push(ch);

            } else {
                operands.push(ch - '0');
            }
        }

        while (operators.size() > 0) {
            char op = operators.pop();
            int ans = evalute(op, operands.pop(), operands.pop());
            operands.push(ans);
        }

        return operands.peek();
    }

    // 17700-->842
    public static void main(String[] args) {

        // String exp = "((a+B)+((a+c))";

        // System.out.println(isDuplicate(exp));

        // int arr[] = { 15, 10, 20, 12, 17, 18, 10, 9, 8, 39, 11 };

        // System.out.println(nextLargerElementRightToLeft(arr));
        // System.out.println(nextLargerElementLeftToRight(arr));

        // Stack<Integer> st = new Stack<>();
        // st.push(1);
        // st.push(2);
        // st.push(3);

        // pushAtBottom(st, 4);

        // System.out.println(st);

        // reverseStack(st);
        // System.out.println(st);

        // String ex = "(4+3)";

        // System.out.println(evealutateInfixExp(ex));

        // int heights[] = { 8, 2, 3, 1, 5, 6, 5, 4, 3, 6 };

        // System.out.println(largestRectangleArea(heights));

        String expression = "2+3*5-8+(4/7+5)*9";
        System.out.println(evaluateExpression(expression));

    }
}
