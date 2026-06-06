
import java.util.HashSet;
//import java.util.Set;

public class longest_Consecutive {

    public static int longestConsecutive(int[] nums) {
        int longest = 1;
        int count;
        int j;
        //int lastSmallest = nums[0];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            count = 0;

            if (!set.contains(nums[i] - 1)) {
                j = 0;

                while (set.contains(nums[i] + j)) {
                    count++;
                    j++;
                }
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3, 100, 104, 102, 103, 106, 107, 105, 101, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 600, 15, 54, 16};
        System.out.println(longestConsecutive(arr));
    }
}
