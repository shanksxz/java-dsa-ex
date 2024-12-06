import java.util.HashSet;

public class FirstRepeatingEle {
  public static void main(String[] args) {
    HashSet<Integer> s = new HashSet<>();
    int arr[] = { 1, 2, 4, 1, 2 };
    int index = -1;

    for (int i = arr.length - 1; i >= 0; i--) {
      if (s.contains(arr[i])) {
        index = i;
      } else {
        s.add(arr[i]);
      }
    }

    if (index != -1) {
      System.out.println("The first repeating element is: " + arr[index]);
    } else {
      System.out.println("No repeating elements found.");
    }
  }
}
