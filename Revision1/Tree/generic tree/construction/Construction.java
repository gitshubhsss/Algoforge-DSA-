
import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int data;
    ArrayList<TreeNode> children;

    TreeNode(int data) {
        this.data = data;
        children = new ArrayList<>();
    }

}

public class Construction {

    public static TreeNode constructTree(int[] dataArray) {
        TreeNode root = null;

        Stack<TreeNode> st = new Stack<>();

        for (int i = 0; i < dataArray.length; i++) {
            int data = dataArray[i];

            if (data == -1) {
                st.pop();
            } else {
                // create a newNode
                TreeNode newNode = new TreeNode(data);
                // check if size=0
                if (st.isEmpty()) {
                    /// Initialze the root node only first time
                    root = newNode;
                } else {
                    st.peek().children.add(newNode);
                }
                st.push(newNode);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        int dataArray[] = {
                10,
                20,
                50,
                -1,
                60,
                -1,
                -1,
                30,
                70,
                -1,
                -1,
                40,
                80,
                -1,
                90,
                110,
                -1,
                120,
                -1,
                -1,
                100,
                -1,
                -1,
                -1,
        };
        TreeNode root = constructTree(dataArray);
    }
}
