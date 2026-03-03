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

  //Node to root path for the binary tree
  public static ArrayList<TreeNode> nodeToRootPath(
    TreeNode root,
    TreeNode target
  ) {
    if (root == null) {
      return new ArrayList<>();
    }

    if (root.equals(target)) {
      ArrayList<TreeNode> baseAns = new ArrayList<>();
      baseAns.add(root);
      return baseAns;
    }

    ArrayList<TreeNode> leftPath = nodeToRootPath(root.left, target);

    if (leftPath.size() > 0) {
      leftPath.add(root);
      return leftPath;
    }

    ArrayList<TreeNode> rightPath = nodeToRootPath(root.right, target);

    if (rightPath.size() > 0) {
      rightPath.add(root);
      return rightPath;
    }

    return new ArrayList<>();
  }

  public void getKLevelDown(
    TreeNode root,
    TreeNode blocker,
    int k,
    ArrayList<Integer> ans
  ) {
    if (root == null || root.equals(blocker) || k < 0) {
      return;
    }

    if (k == 0) {
      ans.add(root);
      return;
    }

    getKLevelDown(root.left, blocker, k - 1, ans);
    getKLevelDown(root.right, blocker, k - 1, ans);
  }

  // Leetcode 863. All Nodes Distance K in Binary Tree ==> https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/1906467213/

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    ArrayList<TreeNode> ntr = nodeToRootPath(root, target);

    List<Integer> ans = new ArrayList<>();

    TreeNode blocker = null;

    for (int i = 0; i < ntr.size(); i++) {
      TreeNode node = ntr.get(i);
      getKLevelDown(node, blocker, k, ans);
      blocker = node;
    }

    return ans;
  }

  TreeNode LCA=null;

  public boolean LCA_better(TreeNode root, TreeNode p, TreeNode q,TreeNode[] LCA) {
    if (root == null) {
      return false;
    }

    boolean self=false;
    if(root.equals.(p)|| root.equals.(q)){
      self=true;
    }

    boolean left=LCA_better(root.left,p,q,LCA);
    boolean right=LCA_better(root.right,p,q,LCA);
    
    if( (left && right) || (self && left) || (self && right) ){
      LCA[0]=root;    
    }

    return self || left || right;
  }



  ///Leetocde ===> 236. Lowest Common Ancestor of a Binary Tree
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    ArrayList<TreeNode> pRootNodePath = getNodeToRootPath(root, p);
    ArrayList<TreeNode> qRootToNodePath = getNodeToRootPath(root, q);

    //initialize the pointers

    int i = pRootNodePath.size() - 1;
    int j = qRootToNodePath.size() - 1;

    while (
      i >= 0 && j >= 0 && pRootNodePath.get(i).equals(qRootToNodePath.get(j))
    ) {
      i--;
      j--;
    }

    return pRootNodePath.get(i + 1);
  }


  //1325. Delete Leaves With a Given Value

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;

    }











    ///=========================================Binary Tree Construction Questions==============================

    /// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    //Make tree from preorder and inorder
     public TreeNode buildTree(int[] preorder, int preSi, int preEi, int[] inorder, int inSi, int inEi) {

        if (preSi > preEi) {
            return null;
        }

        if (preSi == preEi) {
            return new TreeNode(preorder[preSi]);
        }

        TreeNode root = new TreeNode(preorder[preSi]);
        int rootIdx = inSi;
        int leftTreeElements = 0;

        while (rootIdx <= inEi && inorder[rootIdx] != root.val) {
            rootIdx++;
            leftTreeElements++;//3
        }
        
        root.left = buildTree(preorder, preSi + 1, preSi + leftTreeElements, inorder, inSi, rootIdx - 1);
        root.right = buildTree(preorder, preSi + leftTreeElements + 1, preEi, inorder, rootIdx + 1, inEi);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;
        return buildTree(preorder, 0, size - 1, inorder, 0, size - 1);
    }


    //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    ///Make tree from inorder and postorder
    ///Need to do the dryrun changa wala 
       public TreeNode buildTree(int[] postorder, int poSi, int poEi, int[] inorder, int inSi, int inEi) {

        if (inSi > inEi) {
            return null;
        }

        if (poSi == poEi) {
            return new TreeNode(postorder[poEi]);
        }

        TreeNode root = new TreeNode(postorder[poEi]);
        int rootIdx = inSi;
        int leftTreeElements = 0;

        while (rootIdx <= inEi && inorder[rootIdx] != root.val) {
            rootIdx++;
            leftTreeElements++;
        }

        root.left = buildTree(postorder, poSi, poSi + leftTreeElements - 1, inorder, inSi, rootIdx - 1);
        root.right = buildTree(postorder, poSi + leftTreeElements, poEi - 1, inorder, rootIdx + 1, inEi);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = inorder.length;
        return buildTree(postorder, 0, size - 1, inorder, 0, size - 1);
    }



    ///https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
    /////889. Construct Binary Tree from Preorder and Postorder Traversal
    ///Incomplte code

    
    public TreeNode buildTree(int[] preorder, int preSi, int preEi, int[] postorder, int poSi, int poEi) {

        if (preSi > preEi) {
            return null;
        }

        if (preSi == preEi) {
            return new TreeNode(preorder[preSi]);
        }

        TreeNode root = new TreeNode(preorder[preSi]);

        int idx = poSi;

        while (idx <= poEi && postorder[idx] != preorder[preSi + 1]) {
            idx++;
        }
        int leftTreeElements = idx - poSi + 1;

        root.left=buildTree(preorder,preSi+1,preSi+leftTreeElements,postorder,poSi,idx);
        root.right=buildTree(postorder,preSi)

    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int size = preorder.length;

        return buildTree(preorder, 0, size - 1, postorder, 0, size - 1);
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

    Integer arr3[] = {
      3,
      5,
      6,
      null,
      null,
      2,
      7,
      null,
      null,
      4,
      null,
      null,
      1,
      0,
      null,
      null,
      8,
    };

    TreeNode root = buildTree(arr3);

    display(root);

    //  ArrayList<TreeNode> nodes = getKLevelDownFromTargetNode(root, 2, 17);
    // for (TreeNode child : nodes) {
    //   System.out.println(child.data);
    // }
  }
}
