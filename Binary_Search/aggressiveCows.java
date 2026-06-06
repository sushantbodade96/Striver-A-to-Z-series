
import java.util.Arrays;

public class aggressiveCows {

    public static boolean isPossible(int nums[], int cows, int distance) {
        int c = 1;
        int last = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - last >= distance) {
                c++;
                last = nums[i];
            }
            if (c >= cows) {
                return true;
            }
        }

        return false;
    }

    public static int AggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 1;
        int right = nums[n - 1] - nums[0];
        int mid;

        while (left <= right) {
            mid = (right + left) / 2;

            if (isPossible(nums, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;

    }

    public static void main(String[] args) {
        int nums[] = {4, 2, 1, 3, 6};
        System.out.println("The possible distance is : " + AggressiveCows(nums, 2));
    }
}
/*Given an array nums of size n, which denotes the positions of stalls, and an integer k, which denotes the number of aggressive cows, assign stalls to k cows such that the minimum distance between any two cows is the maximum possible. Find the maximum possible minimum distance.


Examples:
Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]

Output: 3

Explanation: The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions [0, 3, 7, 10]. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

Input : n = 5, k = 2, nums = [4, 2, 1, 3, 6]

Output: 5

Explanation: The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions [1, 6].  */
