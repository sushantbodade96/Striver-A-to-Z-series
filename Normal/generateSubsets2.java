
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generateSubsets2 {

    public static void helper(List<List<Integer>> ans, List<Integer> list, int index, int nums[]) {

        ans.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(ans, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }
}
/*90. Subsets II
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10 */
