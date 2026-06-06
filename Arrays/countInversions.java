//Simple merge sort algo to because while merging if right is greater that left we swap and add it to the count

import java.util.Arrays;

public class countInversions {

    public static int merge(int[] nums, int[] temp, int low, int mid, int high) {
        int count = 0;
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
                count = count + (mid - left + 1);
            }
        }

        while (left <= mid) {
            nums[i++] = temp[left++];
        }
        return count;

        // No need to copy right half; already in place
    }

    public static int MS(int[] nums, int[] temp, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }

        int mid = (low + high) / 2;
        count += MS(nums, temp, low, mid);
        count += MS(nums, temp, mid + 1, high);
        count += merge(nums, temp, low, mid, high);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 1, 3, 5};
        int[] temp = new int[nums.length];

        long start = System.nanoTime();
        System.out.println("The number of inversions are : " + MS(nums, temp, 0, nums.length - 1));
        long end = System.nanoTime();

        System.out.println(Arrays.toString(nums));
        System.out.println("Execution time: " + (end - start) + " nanoseconds");
    }
}
