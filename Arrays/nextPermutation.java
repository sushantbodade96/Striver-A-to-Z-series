
import java.util.Arrays;

public class nextPermutation {

    public static void reverse(int arr[], int start) {
        int i = start;
        int j = arr.length - 1;

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        int index2 = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0);
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[index]) {
                    index2 = i;
                    break;

                }
            }
            swap(nums, index, index2);
            reverse(nums, index + 1);
        }

    }

    public static void main(String[] args) {
        int nums[] = {1, 4, 3, 1};

        //System.out.println(Arrays.toString(nums2));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
