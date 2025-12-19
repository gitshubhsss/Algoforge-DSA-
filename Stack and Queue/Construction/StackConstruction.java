import java.util.*;

//construct the stack usring the static array
class MyStack {

  private int data[];
  private int size;
  private int tos;

  private int maxSize = 8;

  MyStack() {
    data = new int[maxSize];
    tos = -1;
  }

  public void resize() {
    //creating the new array with double the lenght
    int newArray[] = new int[data.length * 2];
    for (int i = 0; i < data.length; i++) {
      newArray[i] = data[i]; //copy the previous data
    }
    data = newArray; //point to the new array
  }

  public void push(int val) {
    // static stack
    // if(tos == maxSize - 1){ // data array is completely filled
    //     System.out.println("Stack Overflow!!");
    //     return;
    // }
    if (tos == data.length - 1) {
      resize();
    }
    tos++;
    data[tos] = val;
  }

  public int pop() {
    if (tos == -1) {
      System.out.println("Stack is empty");
      return -1;
    }
    int topValue = data[tos];
    tos--;
    return topValue;
  }

  public int peek() {
    if (tos == -1) {
      System.out.println("stack is emtpy");
      return -1;
    }
    return data[tos];
  }

  public int size() {
    return tos + 1;
  }

  public void print() {
    for (int i = 0; i < data.length; i++) {
      System.out.println(data[i] + "");
    }
  }
}

public class StackConstruction {

  public static void main(String[] args) {
    MyStack st = new MyStack();

    st.push(20);
    st.push(10);
    st.push(60);
    st.push(80);
    st.push(90);
    st.push(100);
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.peek());
    System.out.println("the size fo the stack is " + st.size());
    // System.out.println(st.size());
  }
}
