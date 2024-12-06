public class InsertionSort {
    
    public static void insertionSort(int arr[]) {
        int size = arr.length;
        for(int i = 1; i<size; i++) {
            int key = arr[i];
            int j = i - 1;

            // shift element of arr[0...i-1] that are greater than the key
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // place the key
            arr[j + 1] = key;
            printArray(arr);
        }

    }
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 9, 5, 1, 4, 3 };
        insertionSort(arr);
    }
}