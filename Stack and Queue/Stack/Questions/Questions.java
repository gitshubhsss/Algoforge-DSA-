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
        st.pop(); // popping ='(';
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

    int ngr[] = new int[n]; // to store the ansers

    Stack<Integer> st = new Stack<>();

    st.push(-1); // intial value

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

    int ngr[] = new int[n]; // to store the ansers

    for (int i = 0; i < ngr.length; i++) {
      ngr[i] = -1; // initializing it with -1
    }

    Stack<Integer> st = new Stack<>();

    // traverse from 0 to n

    for (int i = 0; i < n; i++) {
      int curr = arr[i];
      while (st.size() > 0 && arr[st.peek()] <= curr) {
        ngr[st.pop()] = curr;
      }
      st.push(i); // storing the indexes
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

    int ngl[] = new int[n]; // find the next greater on left

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
        while (
          operators.size() > 0 &&
          checkPrecedence(operators.peek()) >= checkPrecedence(ch)
        ) {
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

  //https://leetcode.com/problems/merge-intervals/
  class Pair {

    int startTime;

    int endTime;

    public Pair(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }
  }

  //{{1,3},{2,5},{4,5},{9,10},{11,15},{4,13}}
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (int[] a, int[] b) -> {
      if (a[0] == b[0]) {}

      return a[0] - b[0]; // increasing order on the basis of 0th index, for decreasing b[0] - a[0];
    });

    int n = intervals.length;

    Pair[] timeIntervals = new Pair[n];

    //loop on the sorted array
    for (int i = 0; i < n; i++) {
      timeIntervals[i] = new Pair(intervals[i][0], intervals[i][1]);
    }

    Stack<Pair> st = new Stack<>();

    for (int i = 0; i < timeIntervals.length; i++) {
      Pair curr = timeIntervals[i];

      if (st.size() > 0 && st.peek().endTime >= curr.startTime) {
        Pair prev = st.pop();
        curr.startTime = prev.startTime;
        curr.endTime = Math.max(curr.endTime, prev.endTime);
      }
      st.push(curr);
    }

    int ans[][] = new int[st.size()][2];

    for (int i = 0; i < ans.length; i++) {
      ans[i][0] = st.peek().startTime;
      ans[i][1] = st.peek().endTime;

      st.pop();
    }

    return ans;
  }

  ///https://leetcode.com/problems/min-stack/
  class MinStack {

    Stack<Integer> ogStack;
    Stack<Integer> minStack;

    public MinStack() {
      ogStack = new Stack<>();
      minStack = new Stack<>();
    }

    public void push(int val) {
      if (minStack.size() == 0 || val <= minStack.peek()) {
        minStack.push(val);
      }
      ogStack.push(val);
    }

    public void pop() {
      if (minStack.peek().equals(ogStack.peek())) {
        minStack.pop();
      }

      ogStack.pop();
    }

    public int top() {
      if (ogStack.size() > 0) {
        return ogStack.peek();
      }
      return -1;
    }

    public int getMin() {
      if (minStack.size() > 0) {
        return minStack.peek();
      }
      return -1;
    }
  }

  ///Leetcode 503
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;

    int ngr[] = new int[n];

    Arrays.fill(ngr, -1);

    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < 2 * n; i++) {
      int curr = nums[i % n];

      while (st.size() > 0 && nums[st.peek()] < curr) {
        ngr[st.pop()] = curr;
      }
      if (i < n) {
        st.push(i);
      }
    }

    return ngr;
  }

  //Leetcode 921
  public int minAddToMakeValid(String s) {
    int extra_opening_bracket = 0;
    int opening_bracket_req = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '(') {
        extra_opening_bracket++;
      } else {
        if (extra_opening_bracket == 0) {
          opening_bracket_req++;
        } else {
          extra_opening_bracket--;
        }
      }
    }

    return extra_opening_bracket + opening_bracket_req;
  }

  //letcoe 946,1021,1541===>Homework

  //Leetcode 678
  public boolean checkValidString(String s) {
    int min = 0;
    int max = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (ch == '(') {
        max++;
        min++;
      } else if (ch == ')') {
        max--;
        min--;
      } else if (ch == '*') {
        max++; //consider star as opening
        min--; //consider star as closing
      }

      if (max < 0) {
        return false;
      }

      if (min < 0) {
        min = 0;
      }
    }

    return min == 0;
  }

  //Leetcode 856

  public int scoreOfParentheses(String s) {}

  //Leetcode 456.
  public boolean find132pattern(int[] nums) {
    int n = nums.length;

    int minSoFar[] = new int[n];

    minSoFar[0] = nums[0];
    int min = nums[0];

    for (int i = 1; i < n; i++) {
      min = Math.min(min, nums[i]);
      minSoFar[i] = min;
    }

    Stack<Integer> possibleValues = new Stack<>();
    possibleValues.push(nums[n - 1]); //pushing the last eleent

    for (int j = n - 2; j >= 0; j--) {
      min = minSoFar[j];

      //remove lesser that equal to minimum values

      while (possibleValues.size() > 0 && min >= possibleValues.peek()) {
        possibleValues.pop();
      }

      if (possibleValues.size() > 0 && nums[j] > possibleValues.peek()) {
        return true;
      }

      possibleValues.push(nums[j]);
    }

    return false;
  }

  //HomeWork
  //Leetcode 735
  //3,5,-6,2,-1,4
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < asteroids.length; i++) {
      int val = asteroids[i];

      if (val > 0) {
        st.push(val); //3-6,2
      } else {
        boolean pushNegative = true;

        while (st.size() > 0 && st.peek() > 0) {
          if (st.peek() > -(val)) {
            //push nahi karenge
            pushNegative = false;
            break;
          } else if (st.peek() < -(val)) {
            st.pop(); //3
          } else {
            //equal case
            st.pop();
            pushNegative = false; //push nahi karenge
            break;
          }
        }
        if (pushNegative) {
          st.push(val);
        }
      }
    }
    int ans[] = new int[st.size()];

    for (int i = ans.length - 1; i >= 0; i--) {
      ans[i] = st.pop();
    }

    return ans;
  }

  ///Leetcode 402. Remove K Digits
  public String removeKdigits(String num, int k) {
    // StringBuilder ans = new StringBuilder();

    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < num.length(); i++) {
      int digit = num.charAt(i) - '0';

      while (k > 0 && st.size() > 0 && st.peek() > digit) {
        st.pop();
        k--;
      }

      st.push(digit);
    }

    while (k > 0) {
      st.pop();
      k--;
    }

    StringBuilder sb = new StringBuilder();
    while (st.size() > 0) {
      sb.append(st.pop());
    }

    int j = sb.length() - 1;

    while (j >= 0 && sb.charAt(j) == '0') {
      sb.deleteCharAt(j);
      j--;
    }
    sb.reverse();

    return sb.length() == 0 ? "0" : sb.toString();
  }

  ///Bruit force approch Leetcode 42. Trapping Rain Water
  public int trap(int[] height) {
    int n = height.length;

    int lmax[] = new int[n];
    int rmax[] = new int[n];

    for (int i = 1; i < n; i++) {
      lmax[i] = Math.max(lmax[i - 1], height[i - 1]);
    }

    for (int i = n - 2; i >= 0; i--) {
      rmax[i] = Math.max(rmax[i + 1], height[i + 1]);
    }

    int totalWater = 0;

    for (int i = 1; i <= n - 2; i++) {
      int maxWaterAllowed = Math.min(rmax[i], lmax[i]);

      int currentWaterUnit = Math.max(maxWaterAllowed - height[i], 0);

      totalWater = totalWater + currentWaterUnit;
    }

    return totalWater;
  }

  ///Using stack
  public int trap(int[] height) {
    Stack<Integer> st = new Stack<>();

    int totalWater = 0;

    for (int i = 0; i < height.length; i++) {
      while (st.size() > 0 && height[st.peek()] < height[i]) {
        int right = i;
        int poppedIdx = st.pop();
        if (st.size() == 0) {
          break;
        }
        int left = st.peek();

        int maxWaterAllowed = Math.min(height[left], height[right]);
        int waterHeight = maxWaterAllowed - height[poppedIdx];

        int width = right - left - 1;

        totalWater += (waterHeight * width);
      }

      st.push(i);
    }

    return totalWater;
  }


  //O 1 SPACE
  public int trap(int[] height) {
    int n = height.length;

    int totalWater = 0;

    int left = 0;
    int right = n - 1;

    int lMax = height[0];
    int rMax = height[n - 1];

    while (left < right) {
      if (lMax <= rMax) {
        totalWater += lMax - height[left];
        left++;
        lMax = Math.max(lMax, height[left]);
      } else {
        totalWater += rMax - height[right];
        right--;
        rMax = Math.max(rMax, height[right]);
      }
    }

    return totalWater;
  }


//HOMEWORK
   public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int ansSize = n - (k - 1);

        int ngr[] = new int[ansSize];

        Stack<Integer> stack = new Stack<>();

        //[1,3,-1,-3,5,3,6,7]

        for (int i = 0; i < n; i++) {
            int currEle = arr[i];
            while (stack.size() > 0 && arr[stack.peek()] < currEle) {
                ngr[stack.pop()] = i;
            }
            stack.push(i);
        }

        while(stack.size()>0){
            ngr.push(n);
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
}