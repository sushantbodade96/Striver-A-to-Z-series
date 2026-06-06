
// Take one element and insert it into its correct place in the sorted part.
import java.util.Arrays;

public class insertionSort {

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] IS(int nums[]) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j - 1, j);
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {43, 65, 22, 11, 97, 3, 12};
        long start = System.nanoTime();
        System.out.println(Arrays.toString(IS(nums)));
        long end = System.nanoTime();
        System.out.println("The exceution time is : " + (end - start) + " nano seconds");

    }
}
// O(n2)
// O(n2)
// O(n)
