import java.util.HashMap;
import java.util.HashSet;

public class PairWithDiffK {

  public static int getPairsCount(int[] arr, int n, int k) {
    // int count = 0;
    // for (int i = 0; i < n; i++) {
    //   for (int j = i + 1; j < n; j++) {
    //     if (arr[j] - arr[i] == k) {
    //       count++;
    //     }
    //   }
    // }
    // return count;
    HashSet<Integer> set = new HashSet<>();
    int count = 0;

    for(int num : arr) {
      set.add(num);
    }

    for(int i = 0; i<n; i++) {
      if(set.contains(arr[i] + k)) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    int n = 10;
    int k = 7;

    System.out.println(getPairsCount(arr, n, k));
  }
}
