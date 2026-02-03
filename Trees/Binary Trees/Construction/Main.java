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

class Main {

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

  // //  1,
  //     17,
  //     4,
  //     null,
  //     5,
  //     null,
  //     null,
  //     6,
  //     7,
  //     9,
  //     null,
  //     null,
  //     null,
  //     8,
  //     null,
  //     null,
  //     null,
  //     3,
  //     null,
  //     10,
  //     null,
  //     null,
  //     null,
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

  //Leecode 104 https://leetcode.com/problems/maximum-depth-of-binary-tree/
  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftMaxDepth = maxDepth(root.left);
    int rightMaxDepth = maxDepth(root.right);

    return Math.max(leftMaxDepth, rightMaxDepth) + 1;
  }

  //leetcode Homework 94,144,145

  //leetcode 94
  // public void traverse(TreeNode root, List<Integer> inorder) {
  //   if (root == null) {
  //     return;
  //   }
  //   traverse(root.left, inorder);
  //   inorder.add(root.val);
  //   traverse(root.right, inorder);
  // }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorder = new ArrayList<Integer>();

    traverse(root, inorder);

    return inorder;
  }

  //Leetcode 145
  // public void traverse(TreeNode root, List<Integer> postOrder) {
  //   if (root == null) {
  //     return;
  //   }

  //   traverse(root.left, postOrder);
  //   traverse(root.right, postOrder);
  //   postOrder.add(root.val);
  // }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> postOrder = new ArrayList<>();

    traverse(root, postOrder);

    return postOrder;
  }

  //leetcode 144
  // public void traverse(TreeNode root, List<Integer> preorder) {
  //   if (root == null) {
  //     return;
  //   }
  //   preorder.add(root.val);
  //   traverse(root.left, preorder);
  //   traverse(root.right, preorder);
  // }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preorder = new ArrayList<>();
    traverse(root, preorder);
    return preorder;
  }

  //Traversal using iteratively

  public void traverse(TreeNode root, List<Integer> preorder) {
    Stack<Pair> st = new Stack<>();

    if (root != null) {
      st.push(new Pair(root, 0));
    }

    while (st.size() > 0) {
      //seening for the first time preorder

      TreeNode topNode = st.peek().node;

      if (st.peek().state == 0) {
        st.peek().state++;
        preorder.add(topNode.data);
        if (topNode.left != null) {
          st.push(new Pair(topNode.left, 0));
        }
      } else if (st.peek().state == 1) {
        //seeing for the second time inorder
        st.peek().state++;
        //  inorder.add(topNode.data);
        if (topNode.right != null) {
          st.push(new Pair(topNode.right, 0));
        }
      } else {
        //seening for the last time postorder
        st.pop();
        // postorder.add(topNode.data);
      }
    }
  }

  //Get nodes at kth level down

  public static TreeNode findTargetNode(TreeNode root, int tar) {
    if (root == null) {
      return null;
    }
    if (root.data == tar) {
      return root;
    }

    TreeNode leftAns = findTargetNode(root.left, tar);

    if (leftAns != null) {
      return leftAns;
    }

    TreeNode rightAns = findTargetNode(root.right, tar);

    if (rightAns != null) {
      return rightAns;
    }

    return null;
  }

  public static void getKLevelDown(
    TreeNode root,
    int k,
    ArrayList<TreeNode> ans
  ) {
    if (root == null) {
      return;
    }
    if (k == 0) {
      ans.add(root);
      return;
    }

    getKLevelDown(root.left, k - 1, ans);
    getKLevelDown(root.right, k - 1, ans);
  }

  public static ArrayList<TreeNode> getKLevelDownFromTargetNode(
    TreeNode root,
    int k,
    int tar
  ) {

    TreeNode targetNode = findTargetNode(root, tar);

    ArrayList<TreeNode> ans = new ArrayList<>();

    getKLevelDown(targetNode, k, ans);

    return ans;
  }

  public static void main(String[] args) {
    Integer[] arr = {
      110,
      20,
      40,
      null,
      60,
      null,
      null,
      50,
      70,
      null,
      null,
      null,
      30,
      80,
      90,
      null,
      null,
      100,
      null,
      null,
      null,
    };

    Integer[] arr2 = {
      1,
      17, //17[]
      4, //4
      null, //
      5,
      null, //
      null, //
      6, //6
      7, //7
      9, //9
      null, //
      null, //
      null, //
      8, //
      null, //
      null, //
      3,
      null,
      10,
      null, //
      null, //
    };

    TreeNode root = buildTree(arr2);

    display(root);

    ArrayList<TreeNode> nodes = getKLevelDownFromTargetNode(root, 2, 17);

    for(TreeNode child:nodes){
      System.out.println(child.data);
    }
  }
}
