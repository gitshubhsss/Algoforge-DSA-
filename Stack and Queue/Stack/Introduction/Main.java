package Stack.Introduction;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(4);// at at the top

        System.out.println(st);
        st.pop();
        st.pop();
        st.pop();

        if (!st.isEmpty()) {
            System.out.println(st.peek());
        } else {
            System.out.println("stack is empty");
        }
    }
}
