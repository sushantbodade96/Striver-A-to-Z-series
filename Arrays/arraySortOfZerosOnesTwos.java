
public class arraySortOfZerosOnesTwos {

    // public static void swap(int a, int b) {
    //     int temp = a;
    //     a = b;
    //     b = temp;
    // }
    public static int[] sort(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                //swap(arr[mid], arr[low]);
                low++;
                //if(arr[mid]==arr[low])
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                //swap(arr[mid], arr[high]);
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
            // for (int i = 0; i < arr.length; i++) {
            //     System.out.print(arr[i] + " ");
            // }
            // System.out.println();
        }
        // if (arr[high] == 2 && arr[mid] == 1) {
        //     int temp = arr[mid];
        //     arr[mid] = arr[high];
        //     arr[high] = temp;
        // }
        // if (arr[mid] == 0) {
        //     arr[mid] = 1;
        //     arr[low] = 0;
        // }
        // if (arr[mid] == 2) {
        //     arr[mid] = 1;
        //     arr[high] = 2;
        // }

        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {0, 2, 2, 1, 1, 0, 0, 2, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        arr = sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        //swap(a, b);
        // System.out.println(a + " " + b);
    }
}
