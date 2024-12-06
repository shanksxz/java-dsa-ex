import java.util.*;

public class SubsqSumK {

    public static void SumK(int arr[], int index, List<Integer> curr, List<List<Integer>> result, int sum, int key) {
        if(index == arr.length) {
            if(sum == key) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        curr.add(arr[index]);
        SumK(arr, index + 1, curr, result, sum + arr[index], key);

        curr.remove(curr.size() - 1);
        SumK(arr, index + 1, curr, result, sum, key);

    }

    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int sum = 2;
        List<List<Integer>> subsq = new ArrayList<>();

        SumK(arr, 0, new ArrayList<>(), subsq, 0, sum);
        for(List<Integer> x : subsq) {
            System.out.println(x);
        }

    }
}
