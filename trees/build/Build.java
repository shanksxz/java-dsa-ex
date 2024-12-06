import java.util.*;

class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
    this.left = this.right = null;
  }
}

public class Build {

  public static Node buildTree(Scanner sc) {
    int data = sc.nextInt();

    if (data == -1) {
      return null;
    }

    // create root
    Node root = new Node(data);

    // root->left
    root.left = buildTree(sc);

    // root->right
    root.right = buildTree(sc);

    // return root;
    return root;
  }

  public static Node buildTreeLevelOrder(Scanner sc) {
    // create root ele
    int x = sc.nextInt();
    Node root = new Node(x);

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      // get the curr node and remove
      Node curr = queue.poll();

      // left
      int left = sc.nextInt();
      if (left != -1) {
        curr.left = new Node(left);
        queue.add(curr.left);
      }

      // right
      int right = sc.nextInt();
      if (right != -1) {
        curr.right = new Node(right);
        queue.add(curr.right);
      }
    }

    return root;
  }

  public static void preOrder(Node root) {
    if (root == null)
      return;
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void inOrder(Node root) {
    if (root == null)
      return;
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public static void postOrder(Node root) {
    if (root == null)
      return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data);
  }

  public static void levelOrder(Node root) {
    if (root == null)
      return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      System.out.print(curr.data + " ");

      if (curr.left != null) {
        queue.add(curr.left);
      }

      if (curr.right != null) {
        queue.add(curr.right);
      }
    }

    System.out.println();
  }

  public static void levelOrderLineWise(Node root) {
    if (root == null)
      return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        System.out.print(curr.data + " ");

        if (curr.left != null) {
          queue.add(curr.left);
        }

        if (curr.right != null) {
          queue.add(curr.right);
        }
      }

      System.out.println();
    }

    System.out.println();
  }

  public static void printOddLevel(Node root) {
    if (root == null)
      return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    boolean isOdd = true;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node curr = q.poll();

        if (isOdd) {
          System.out.print(curr.data + " ");
        }

        if (curr.left != null) {
          q.add(curr.left);
        }
        if (curr.right != null) {
          q.add(curr.right);
        }
      }
      isOdd = !isOdd;
      // System.out.println();
    }
  }

  static int postIndex;

  public static Node buildFromInPost(int[] in, int[] post, int n) {
    postIndex = n - 1;
    Node root = help(in, post, 0, n - 1);
    return root;
  }

  public static Node help(int[] in, int[] post, int start, int end) {
    if (start > end)
      return null;
    Node root = new Node(post[postIndex--]);

    int j = -1;
    for (int i = start; i <= end; i++) {
      if (in[i] == root.data) {
        j = i;
        break;
      }
    }

    root.right = help(in, post, j + 1, end);
    root.left = help(in, post, start, j - 1);
    return root;
  }

  public static int countLeafNode(Node root) {
    if (root == null)
      return 0;
    if (root.left == null & root.right == null)
      return 1;
    return countLeafNode(root.left) + countLeafNode(root.right);
  }

  public static int countNonLeafNode(Node root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 0;
    return 1 + countNonLeafNode(root.left) + countNonLeafNode(node.right);
  }

  public static int height(Node root) {
    if (root == null)
      return 0;
    int left = height(root.left);
    int right = height(root.right);
    return Math.max(left, right) + 1;
  }

  static int totalPaths;

  public static void helper(Node root, StringBuilder path) {
    if (root == null)
      return;
    int len = path.length();
    path.append(root.data);

    if (root.left == null && root.right == null) {
      totalPaths++;
      System.out.println(path.toString() + " " + (path.toString().split(" ").length - 1));
    } else {
      path.append(" ");
      helper(root.left, path);
      helper(root.right, path);
    }

    path.setLength(len);
  }

  public static void printAllPaths(Node root) {
    StringBuilder paths = new StringBuilder();
    helper(root, paths);
    System.out.print(totalPaths);

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Node root = buildTree(sc);
    Node root = buildTreeLevelOrder(sc);
    levelOrderLineWise(root);

    System.out.println(height(root));
  }
}
