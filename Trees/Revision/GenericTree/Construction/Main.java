import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {

  int data;
  ArrayList<TreeNode> children;

  public TreeNode(int data) {
    this.data = data;
    children = new ArrayList<>();
  }
}

public class Main {

  public static TreeNode buildTree(int arr[]) {
    TreeNode root = null;
    Stack<TreeNode> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      int data = arr[i];

      if (data == -1) {
        if (st.size() > 0) {
          st.pop();
        }
      } else {
        //create the new TreeNode
        TreeNode newNode = new TreeNode(data);

        if (st.size() == 0) {
          root = newNode;
        } else {
          TreeNode topNode = st.peek();
          topNode.children.add(newNode);
        }

        st.push(newNode);
      }
    }

    return root;
  }

  public static void display(TreeNode root) {
    //this is optional Cause we have used the for loop

    if (root == null) {
      return;
    }
    System.out.print(root.data + "--->");

    for (TreeNode child : root.children) {
      System.out.print(child.data + " ");
    }

    System.out.println();

    for (TreeNode child : root.children) {
      display(child);
    }
  }

  public static void levelOrderTraverse4(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    que.add(root);
    que.add(null);

    while (que.size() > 0) {
      TreeNode topNode = que.removeFirst();

      if (topNode == null) {
        if (que.size() > 0) {
          que.add(null);
        }
        System.out.println();
      } else {
        System.out.print(topNode.data + " ");

        for (TreeNode child : topNode.children) {
          que.add(child);
        }
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = {
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

    TreeNode root = buildTree(arr);

    levelOrderTraverse4(root);

    TreeNode mirrorNode = makeMirror(root);

    levelOrderTraverse4(mirrorNode);
  }
}
