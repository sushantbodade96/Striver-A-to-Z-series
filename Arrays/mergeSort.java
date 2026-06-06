
import java.util.Arrays;

public class mergeSort {

    public static void merge(int[] nums, int[] temp, int low, int mid, int high) {
        // Copy nums[low..high] into temp[low..high]
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }

        int left = low;
        int right = mid + 1;
        int i = low;

        while (left <= mid && right <= high) {
            if (temp[left] <= temp[right]) {
                nums[i++] = temp[left++];
            } else {
                nums[i++] = temp[right++];
            }
        }

        while (left <= mid) {
            nums[i++] = temp[left++];
        }

        // No need to copy right half; already in place
    }

    public static void MS(int[] nums, int[] temp, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        MS(nums, temp, low, mid);
        MS(nums, temp, mid + 1, high);
        merge(nums, temp, low, mid, high);
    }

    public static void main(String[] args) {
        int[] nums = {43, 65, 22, 11, 97, 3, 12};
        int[] temp = new int[nums.length];

        long start = System.nanoTime();
        MS(nums, temp, 0, nums.length - 1);
        long end = System.nanoTime();

        System.out.println(Arrays.toString(nums));
        System.out.println("Execution time: " + (end - start) + " nanoseconds");
    }
}
