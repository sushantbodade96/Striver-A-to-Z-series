
import java.util.Arrays;

public class first_last_Occurence {

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int ans[] = {-1, -1};

        int left = 0;
        int right = n - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target) {
                int first = mid;
                int last = mid;

                while (first > 0 && nums[first - 1] == target) {
                    first--;
                }
                while (last < n - 1 && nums[last + 1] == target) {
                    last++;
                }
                ans[0] = first;
                ans[1] = last;
                return ans;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 10};
        int ans[] = searchRange(nums, 8);

        System.out.println(Arrays.toString(ans));

    }
}
