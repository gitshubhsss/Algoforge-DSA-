import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {

  int data;

  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
  }
}

class Pair {

  TreeNode node;
  int state;

  public Pair(TreeNode node, int state) {
    this.node = node;
    this.state = state;
  }
}

public class Questions {

  public static TreeNode buildTree(Integer[] arr) {
    TreeNode root = null;

    Stack<Pair> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      Integer ele = arr[i];

      if (ele == null) {
        if (st.size() == 0) {
          return null;
        } else if (st.peek().state == 0) {
          //simply increase the state
          st.peek().state++;
        } else {
          //if the state is 1 then pop it from the stack means right is also null
          st.pop();
        }
      } else {
        //making the new node
        TreeNode newNode = new TreeNode(ele);
        if (st.size() == 0) {
          root = newNode;
        } else if (st.peek().state == 0) {
          st.peek().node.left = newNode;
          st.peek().state++;
        } else {
          st.peek().node.right = newNode;
          st.pop();
        }
        st.push(new Pair(newNode, 0));
      }
    }

    return root;
  }

  public static void display(TreeNode root) {
    if (root == null) {
      return;
    }

    String nodeStructure =
      (root.left == null ? "." : root.left.data) +
      "<- " +
      root.data +
      " ->" +
      (root.right == null ? "." : root.right.data);

    System.out.println(nodeStructure);

    display(root.left);
    display(root.right);
  }

  //https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1==============================================================>

  class Solution {

    class Pair {

      Node node;
      int verticalLevel;

      public Pair(Node node, int verticalLevel) {
        this.node = node;
        this.verticalLevel = verticalLevel;
      }
    }

    public void traverse(Node root, int verticalLevel, int[] minMax) {
      if (root == null) {
        return;
      }

      minMax[0] = Math.min(minMax[0], verticalLevel);
      minMax[1] = Math.max(minMax[1], verticalLevel);

      traverse(root.left, verticalLevel - 1, minMax);
      traverse(root.right, verticalLevel + 1, minMax);
    }

    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
      // code here

      int minMax[] = new int[2];

      traverse(root, 0, minMax);

      int shift = -minMax[0];

      int width = minMax[1] - minMax[0] + 1;

      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

      for (int i = 0; i < width; i++) {
        ans.add(new ArrayList<Integer>());
      }

      LinkedList<Pair> que = new LinkedList<>();

      que.addLast(new Pair(root, shift));

      while (que.size() > 0) {
        int size = que.size();

        while (size > 0) {
          Pair front = que.removeFirst();

          Node node = front.node;

          int currentLevel = front.verticalLevel;

          ans.get(currentLevel).add(node.data);

          if (node.left != null) {
            que.addLast(new Pair(node.left, currentLevel - 1));
          }

          if (node.right != null) {
            que.addLast(new Pair(node.right, currentLevel + 1));
          }

          size--;
        }
      }

      return ans;
    }
  }

  //https://www.geeksforgeeks.org/problems/vertical-sum/1 =========================================================================>
  class Solution {

    class Pair {

      Node node;
      int verticalLevel;

      public Pair(Node node, int verticalLevel) {
        this.node = node;
        this.verticalLevel = verticalLevel;
      }
    }

    public void traverse(Node root, int verticalLevel, int[] minMax) {
      if (root == null) {
        return;
      }

      minMax[0] = Math.min(minMax[0], verticalLevel);
      minMax[1] = Math.max(minMax[1], verticalLevel);

      traverse(root.left, verticalLevel - 1, minMax);
      traverse(root.right, verticalLevel + 1, minMax);
    }

    public ArrayList<Integer> verticalSum(Node root) {
      // add your code here

      int minMax[] = new int[2];

      traverse(root, 0, minMax);

      int shift = -minMax[0];

      int width = minMax[1] - minMax[0] + 1;

      ArrayList<Integer> ans = new ArrayList<>();

      for (int i = 0; i < width; i++) {
        ans.add(0);
      }

      LinkedList<Pair> que = new LinkedList<>();

      que.add(new Pair(root, shift));

      while (que.size() > 0) {
        int size = que.size();

        while (size > 0) {
          Pair frontNode = que.removeFirst();
          Node node = frontNode.node;

          int currentLevel = frontNode.verticalLevel;

          ans.set(currentLevel, ans.get(currentLevel) + node.data);

          if (node.left != null) {
            que.add(new Pair(node.left, currentLevel - 1));
          }

          if (node.right != null) {
            que.add(new Pair(node.right, currentLevel + 1));
          }

          size--;
        }
      }

      return ans;
    }
  }

  ///https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1=============================================================>

  class Solution {

    class Pair {

      Node node;
      int verticalLevel;

      public Pair(Node node, int verticalLevel) {
        this.node = node;
        this.verticalLevel = verticalLevel;
      }
    }

    public void traverse(Node root, int verticalLevel, int[] minMax) {
      if (root == null) {
        return;
      }

      minMax[0] = Math.min(minMax[0], verticalLevel);
      minMax[1] = Math.max(minMax[1], verticalLevel);

      traverse(root.left, verticalLevel - 1, minMax);
      traverse(root.right, verticalLevel + 1, minMax);
    }

    public ArrayList<Integer> bottomView(Node root) {
      // code here

      int minMax[] = new int[2];

      traverse(root, 0, minMax);

      int shift = -minMax[0];

      int width = minMax[1] - minMax[0] + 1;

      ArrayList<Integer> ans = new ArrayList<>();

      for (int i = 0; i < width; i++) {
        ans.add(0);
      }

      LinkedList<Pair> que = new LinkedList<>();

      que.add(new Pair(root, shift));

      while (que.size() > 0) {
        int size = que.size();

        while (size > 0) {
          Pair frontNode = que.removeFirst();
          Node node = frontNode.node;

          int currentLevel = frontNode.verticalLevel;

          ans.set(currentLevel, frontNode.node.data);

          if (node.left != null) {
            que.add(new Pair(node.left, currentLevel - 1));
          }

          if (node.right != null) {
            que.add(new Pair(node.right, currentLevel + 1));
          }

          size--;
        }
      }

      return ans;
    }
  }

  ///https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1==========================================================>

  ///https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1========================================>

  public static void main(String[] args) {
    Integer[] arr = {
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      null,
      null,
      null,
      8,
      null,
      9,
      null,
      10,
      11,
      null,
    };

    TreeNode root = buildTree(arr);
    display(root);
  }
}
