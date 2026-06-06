
import java.util.Arrays;

public class minDaysToMakeBouquet {

    public static boolean isPossible(int nums[], int day, int m, int k) {
        int count = 0;
        int bouquets = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }
        bouquets += count / k;
        return bouquets >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();
        int mid;
        int ans = right;
        if (m * k > n) {
            return -1;
        }

        while (left <= right) {
            mid = (right + left) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {7, 7, 7, 7, 12, 7, 7};
        System.out.println("Min days to make bouquets are : " + minDays(nums, 2, 3));
    }
}
