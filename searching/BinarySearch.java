public class BinarySearch {
    
  public static int bs(int[] arr, int low, int high, int key) {
    while(low <= high) {
      int mid = low + (high - low)/2;

      if(arr[mid] == key) {
        return mid;
      }

      if(arr[mid] < key) {
        return bs(arr, mid + 1, high, key);
      }

      return bs(arr, low, mid - 1, key);
    }

    return -1;
  }

  public static int bs2(int[] arr, int key) {
    int low = 0;
    int high = arr.length - 1;
    while(low <= high) {
      int mid = low + (high  - low)/2;


      if(arr[mid] == key) {
        return mid;
      }

      if(arr[mid] < key) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5};
    int key = 2;
    System.out.println(bs2(arr, key));
    System.out.println(bs(arr, 0, arr.length - 1, key));
  }
}
