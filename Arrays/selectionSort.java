
import java.util.Arrays;

public class selectionSort {

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] SS(int nums[]) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    swap(nums, i, j);
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {43, 65, 22, 11, 97, 3, 12};
        long start = System.nanoTime();
        System.out.println(Arrays.toString(SS(nums)));
        long end = System.nanoTime();
        System.out.println("The exceution time is : " + (end - start) + " nano seconds");

    }
}

// O(n2)
// O(n2)
// O(n2)
