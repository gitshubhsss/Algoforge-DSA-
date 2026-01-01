///https://www.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1

public class TwoStackOneArray {

  int arr[];
  int tos1;
  int tos2;

  TwoStackOneArray() {
    arr = new int[2000];
    tos1 = -1;
    tos2 = arr.length;
  }

  // Function to push an integer into the stack1.
  void push1(int x) {
    // code here
    if (tos1 + 1 >= tos2) { //overflow condition
      return;
    }
    tos1++;
    arr[tos1] = x;
  }

  // Function to push an integer into the stack2.
  void push2(int x) {
    // Code here
    if (tos1 + 1 >= tos2) {
      return;
    }
    tos2--;
    arr[tos2] = x;
  }

  // Function to remove an element from top of the stack1.

  int pop1() {
    // code here
    if (tos1 == -1) {
      return -1;
    }
    int popedValue = arr[tos1];
    tos1--;
    return popedValue;
  }

  // Function to remove an element from top of the stack2.
  int pop2() {
    // code here
    if (tos2 == arr.length) {
      return -1;
    }
    int popedValue = arr[tos2];
    tos2++;
    return popedValue;
  }

  public static void main(String args[]) {}
}
