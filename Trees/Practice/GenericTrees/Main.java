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

public class Main {

  //construct tree function

  public static TreeNode constructTree(int dataArray[]) {
    Stack<TreeNode> st = new Stack<>();

    TreeNode root = null;

    for (int i = 0; i < dataArray.length; i++) {
      int data = dataArray[i];

      if (data == -1) {
        st.pop();
      } else {
        //create the new node

        TreeNode newNode = new TreeNode(data);

        if (st.size() == 0) {
          root = newNode;
        } else {
          st.peek().children.add(newNode);
        }

        st.push(newNode);
      }
    }

    return root;
  }

  public static void display(TreeNode root) {
    System.out.print(root.data + "---> ");

    for (TreeNode child : root.children) {
      System.out.print(child.data + " ");
    }
    System.out.println();

    for (TreeNode child : root.children) {
      display(child);
    }
  }

  public static int getMaximum(TreeNode root) {
    int treeMax = root.data;

    for (TreeNode child : root.children) {
      treeMax = Math.max(getMaximum(child), treeMax);
    }

    return treeMax;
  }

  public static int getMaxHeight(TreeNode root) {
    if (root == null) {
      return -1;
    }
    int treeMaxHeight = -1;

    for (TreeNode child : root.children) {
      int childMaxHeight = getMaxHeight(child);
      treeMaxHeight = Math.max(childMaxHeight, treeMaxHeight);
    }

    return treeMaxHeight + 1;
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
    display(root);

    System.out.println("Maximum : " + getMaximum(root));
    System.out.println("Tree max height : " + getMaxHeight(root));
  }
}
