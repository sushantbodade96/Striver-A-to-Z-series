
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maxDifferenceOfK {

    public static int[][] divideArray(int[] nums, int k) {
        // Step 1: Sort the array to group close elements together
        Arrays.sort(nums);

        // Step 2: Prepare list to collect valid triplets
        List<int[]> result = new ArrayList<>();

        // Step 3: Traverse in steps of 3
        for (int i = 0; i < nums.length; i += 3) {
            // Check if there are enough elements left for a group
            if (i + 2 >= nums.length) {
                return new int[0][];
            }
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            // Step 3.1: Check if the max difference in this group is ≤ k
            if (c - a > k) {
                return new int[0][];
            }

            // Step 3.2: Add the group to result
            result.add(new int[]{a, b, c});
        }

        // Step 4: Convert list to array and return
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 4, 2, 1, 5, 6, 7};
        int k[][] = divideArray(arr, 2);
        System.out.println(Arrays.deepToString(k));

    }
}
