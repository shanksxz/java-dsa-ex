import java.util.*;

class HashMapEx {
  public static void main(String[] args) {
    HashMap<Integer, Integer> map = new HashMap<>();

    int arr[] = {1,1,1,2,3};

    for(int i = 0; i<arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    

    for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
      System.out.println(mp.getKey() + " " + mp.getValue());
    }
  }
}
