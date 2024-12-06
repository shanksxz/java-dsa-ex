public class BubbleSort {
    
    public static void bubbleSort(int arr[]) {
        int size = arr.length;
        for(int i = 0; i<size - 1; i++) {
            for(int j = 0; j<size - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printArray(arr);
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {-2, 45, 0, 11, -9};
        bubbleSort(arr);
    }
}
