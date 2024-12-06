import java.util.*;

public class Subsequences {
    
    public static void includeExclude(int arr[], int index, List<Integer> curr, List<List<Integer>> result) {
      
      if(index >= arr.length) {
        result.add(new ArrayList<>(curr));
        return;
      }
      
      //include curr element in the subsequence
      curr.add(arr[index]);
      includeExclude(arr, index + 1, curr, result);
      
      //exclude curr element in the subsequence
      curr.remove(curr.size() - 1); //remove the last added ele
      includeExclude(arr, index + 1, curr, result);

    }

    public static void backtrack(int arr[], int index, List<Integer> curr, List<List<Integer>> result) {
      // add curr state
      result.add(new ArrayList<>(curr));

      // try diff paths starting from here
      for(int start = index; start < arr.length; start++) {
        // try this path
        curr.add(arr[start]);

        backtrack(arr, start + 1, curr, result);

        //undo the path
        curr.remove(curr.size() - 1);
      }
    } 

    public static void main(String[] args) {
      
      int arr[] = {3,1,2};

      List<List<Integer>> subsequence = new ArrayList<>();

      includeExclude(arr, 0, new ArrayList<>(), subsequence);

      for(List<Integer> ss : subsequence) {
        System.err.println(ss);
      }

      System.out.println("");

      subsequence = new ArrayList<>();
      backtrack(arr, 0, new ArrayList<>(), subsequence);

      for(List<Integer> ss : subsequence) {
        System.err.println(ss);
      }
    }
}
