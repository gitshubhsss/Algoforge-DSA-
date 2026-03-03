class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;

  TreeNode() {}

  TreeNode(int data) {
    this.data = data;
  }

  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}

class Questions {

  public static TreeNode buildBST(int[] arr, int si, int ei) {
    if (si > ei) {
      return null;
    }

    int mid = (si + ei) / 2;

    TreeNode root = new TreeNode(arr[mid]);

    root.left = buildBST(arr, si, mid - 1);
    root.right = buildBST(arr, mid + 1, ei);

    return root;
  }

  public static void display(TreeNode root) {
    if (root == null) return;

    String nodeStructure =
      (root.left == null ? "." : root.left.data) +
      " <- " +
      root.data +
      " -> " +
      (root.right == null ? "." : root.right.data);

    System.out.println(nodeStructure);
    display(root.left);
    display(root.right);
  }

  //GFG ===//https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1

  //Approach 1 Recursively
  public int minValue(TreeNode root) {
    if (root == null) {
      return -1;
    }

    int val = minValue(root.left);

    if (val == -1) {
      return root.data;
    }

    return val;
  }

  //Approarch three

  public int minValue(TreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    if (root.left == null) return root.data;

    return minValue(root.left);
  }

  //GFG ===//https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
  //Approach 3 Iteratively
  public int minValue(TreeNode root) {
    TreeNode temp = root;

    while (temp.left != null) {
      temp = temp.left;
    }

    return temp.data;
  }

  public int maxValue(TreeNode root) {
    if (root == null) {
      return -1;
    }

    int max = maxValue(root.right);
    if (max == -1) {
      return root.val;
    }

    return max;
  }

  //Leetcode = 700. Search in a Binary Search Tree https://leetcode.com/problems/search-in-a-binary-search-tree/
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    if (root.val == val) {
      return root;
    }
    //agar value wadi hai te right de jao
    if (root.val < val) {
      return searchBST(root.right, val);
    } else {
      return searchBST(root.left, val);
    }
  }

  //Leetcode 701 ==============>https://leetcode.com/problems/insert-into-a-binary-search-tree/
  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (root.val < val) {
      root.right = insertIntoBST(root.right, val);
    } else {
      root.left = insertIntoBST(root.left, val);
    }

    return root;
  }

  ///Leetcode 450. Delete Node in a BST
  public TreeNode findLeftMost(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public TreeNode findRightMost(TreeNode root) {
    while (root.right != null) {
      root = root.right;
    }

    return root;
  }

  /// Often ask in interviews
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else {
      //ab toh delete krna hi hai
      //right exist krta hai-> toh right se element le aao,nhi kra toh edge hai ya leaf
      if (root.left == null && root.right == null) {
        return null;
      }

      //only one child
      if (root.left != null && root.right == null) {
        return root.left;
      } else if (root.left == null && root.right != null) {
        return root.right;
      }

      //both children
      TreeNode justGreater = findLeftMost(root.right);
      root.val = justGreater.val;
      root.right = deleteNode(root.right, justGreater.val);
    }

    return root;
  }

  ///669. Trim a Binary Search Tree=================>https://leetcode.com/problems/trim-a-binary-search-tree/description/

  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root = null) {
      return null;
    }

    if (root.val <= high && root.val >= low) {
      root.right = trimBST(root.right, low, hight);
      root.left = trimBST(root.left, low, high);
    }

    if (root.val < low) {
      return trimBST(root.right, low, high);
    }
    if (root.val > high) {
      return trimBST(root.left, low, high);
    }

    return root;
  }

  //538. Convert BST to Greater Tree===============>https://leetcode.com/problems/convert-bst-to-greater-tree/description/

  public TreeNode convertBST(TreeNode root) {
    return null;
  }

  //HomeWork
  // 1) https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
  // 2) https://www.geeksforgeeks.org/problems/construct-bst-from-post-order/1

  //1008. Construct Binary Search Tree from Preorder Traversal
  public TreeNode makeBSTFromPreOrder(
    int[] preorder,
    int[] idx,
    int lowerBound,
    int upperBound
  ) {
    if (
      idx[0] >= preorder.length ||
      preorder[idx[0]] <= lowerBound ||
      preorder[idx[0]] >= upperBound
    ) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[idx[0]]);
    idx[0]++;

    root.left = makeBSTFromPreOrder(preorder, idx, lowerBound, root.val);
    root.right = makeBSTFromPreOrder(preorder, idx, root.val, upperBound);

    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    int idx[] = new int[1];

    return makeBSTFromPreOrder(
      preorder,
      idx,
      Integer.MIN_VALUE,
      Integer.MAX_VALUE
    );
  }

  ///Check for BST https://www.geeksforgeeks.org/problems/check-for-bst/1=======================>Dryrun pending

  class BstPair {

    int max;
    int min;
    boolean isBst;

    public BstPair() {}

    public BstPair(int min, int max, boolean isBst) {
      this.min = min;
      this.max = max;
      this.isBst = isBst;
    }
  }

  public BstPair checkIfBst(Node root) {
    if (root == null) {
      return new BstPair(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
    }

    BstPair leftPair = checkIfBst(root.left); //-inf,inf,t
    BstPair rightPair = checkIfBst(root.right); //-inf,inf,t

    //preparing the answer
    BstPair ansPair = new BstPair();

    ansPair.isBst = (leftPair.isBst &&
      rightPair.isBst &&
      leftPair.max < root.data &&
      root.data < rightPair.min);

    ansPair.min = Math.min(leftPair.min, root.data);
    ansPair.max = Math.max(rightPair.max, root.data);

    return ansPair;
  }

  public boolean isBST(Node root) {
    return checkIfBst(root).isBst;
  }

  //Letcode 1373 Maxisum sum of a bst subtree========================================================>


  



  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 5, 8, 10, 12, 13, 15, 18 };

    TreeNode root = buildBST(arr, 0, arr.length - 1);
    display(root);
  }
}
