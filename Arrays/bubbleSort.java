
//pushes biggest number in last
//Optimization added with the help of swapcount , if array is already sorted then just break loop

import java.util.Arrays;

public class bubbleSort {

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] BS(int nums[]) {
        int n = nums.length;
        
        // int i = 0;
        int j = n - 1;
        while (j > 0) {
            int swapCount = 0;
            for (int k = 0; k < j; k++) {
                if (nums[k] > nums[k + 1]) {
                    swap(nums, k, k + 1);
                    swapCount = 1;
                }
            }
            if (swapCount == 0) {
                break;
            }
            j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {43, 65, 22, 11, 97, 3, 12};
        long start = System.nanoTime();
        System.out.println(Arrays.toString(BS(nums)));
        long end = System.nanoTime();
        System.out.println("The exceution time is : " + (end - start) + " nano seconds");

    }
}




// O(n2)
// O(n2)
// O(n)
