import java.awt.Panel;
import java.util.*;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    this.left = this.right = null;
  }
}

public class Heapify {

  public static void buildMaxHeap(int[] arr, int n) {
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }
  }

  public static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }

    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, n, largest);
    }
  }

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static Node buildLevelOrder(int arr[], int n) {
    // root ele
    Node root = new Node(arr[0]);
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int i = 1;
    while (!q.isEmpty() && i < n) {
      Node curr = q.poll();

      if (i < n) {
        curr.left = new Node(arr[i++]);
        q.add(curr.left);
      }

      if (i < n) {
        curr.right = new Node(arr[i++]);
        q.add(curr.right);
      }
    }

    return root;
  }

  public static void printLevelOrder(Node root) {
    if (root == null)
      return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node curr = q.poll();

        System.out.print(curr.data + " ");

        if (curr.left != null) {
          q.add(curr.left);
        }

        if (curr.right != null) {
          q.add(curr.right);
        }
      }

      System.out.println();
    }
  }

  public static void printKLargest(int array[], int n, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int num : array) {
      maxHeap.add(num);
    }

    for (int i = 0; i < k; i++) {
      System.out.print(maxHeap.poll());
      if (i < k - 1) {
        System.out.print(" ");
      }
    }
  }

  public static int isMaxHeap(int arr[], int n) {
    for (int i = 0; i <= (n - 2) / 2; i++) {
      if (2 * i + 1 < n && arr[i] < arr[2 * i + 1])
        return 0;
      if (2 * i + 2 < n && arr[i] < arr[2 * i + 2])
        return 0;
    }
    return 1;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 12, 9, 5, 6, 10 };
    int n = 6;

    buildMaxHeap(arr, n);
    Node root = buildLevelOrder(arr, n);
    printLevelOrder(root);
  }
}
