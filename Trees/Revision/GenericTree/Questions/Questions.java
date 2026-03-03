import java.util.*;

class TreeNode {

  int data;
  ArrayList<TreeNode> children;

  public TreeNode() {}

  public TreeNode(int data) {
    this.data = data;
    children = new ArrayList<TreeNode>();
  }
}

public class Questions {

  public static TreeNode constructTree(int arr[]) {
    TreeNode root = null;
    Stack<TreeNode> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      int data = arr[i];
      if (data == -1) {
        st.pop();
      } else {
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
    System.out.print(root.data + "---->");

    for (TreeNode child : root.children) {
      System.out.print(root.data + " ");
    }

    System.out.println();

    for (TreeNode child : root.children) {
      display(child);
    }
  }

  public static int size(TreeNode root) {
    int mySize = 0;

    for (TreeNode child : root.children) {
      int childSize = size(child); //faith is that it will give me the child  ki size
      mySize = mySize + childSize;
    }

    return mySize + 1;
  }

  public static int getMaximum(TreeNode root) {
    int max = root.data;

    for (TreeNode child : root.children) {
      int childMax = getMaximum(child);
      max = Math.max(max, childMax);
    }

    return max;
  }

  //Height of tree = Max Depth of Tree

  public static int findMaxHeight(TreeNode root) {
    int maxHeight = -1;

    for (TreeNode child : root.children) {
      int childMaxHeight = findMaxHeight(child);
      maxHeight = Math.max(maxHeight, childMaxHeight) + 1;
    }

    return maxHeight;
  }

  ///Traverse
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

  ///========================================================================================Mirror a tree==========================================================

  public static TreeNode makeMirror(TreeNode root) {
    int childrenSize = root.children.size();

    int left = 0;
    int right = childrenSize - 1;

    while (left <= right) {
      TreeNode leftMirror = makeMirror(root.children.get(left));

      TreeNode rightMirror =
        left > right
          ? makeMirror(root.children.get(right))
          : root.children.get(right);

      // swap nodes at position left and right
      root.children.set(left, rightMirror);
      root.children.set(right, leftMirror);

      left++;
      right--;
    }

    return root;
  }

  //================================================================Remove all leaf nodes from a Generic Tree or N-ary Tree=================================

  public static TreeNode removeLeafNodes(TreeNode root) {
    for (TreeNode child : root.children) {
      removeLeafNodes(child);
    }

    return root;
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
      80,
      100,
      -1,
      110,
      -1,
      -1,
      90,
      -1,
      -1,
      40,
      120,
      -1,
      -1,
      -1,
    };

    TreeNode root = constructTree(arr);

    levelOrderTraverse4(root);

    // display(root);

    System.out.println("======================>");

    TreeNode node = removeLeafNodes(root);

    levelOrderTraverse4(node);

    //TreeNode mirrorRoot = makeMirror(root);

    //  levelOrderTraverse4(mirrorRoot);

    // display(mirrorRoot);

    // System.out.println(size(root));

    // System.out.println("Maximum of the GT is " + getMaximum(root));

    // System.out.println("Maximum height of tree is " + findMaxHeight(root));

    //  levelOrderTraversal(root);
  }
}
