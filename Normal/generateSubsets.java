
import java.util.ArrayList;

public class generateSubsets {

    public static ArrayList<ArrayList<Integer>> generate(int nums[]) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateAllSets(0, result, nums, new ArrayList<>());
        return result;
    }

    public static void generateAllSets(int index, ArrayList<ArrayList<Integer>> result, int nums[], ArrayList<Integer> currentList) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        //exclude current element
        generateAllSets(index + 1, result, nums, currentList);

        //include current element
        currentList.add(nums[index]);
        generateAllSets(index + 1, result, nums, currentList);

        //remove last element because now it has added in list and we want to make new subsequence so it should be removed and new will be added
        currentList.remove(currentList.size() - 1);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(generate(nums));
    }
}
/*78. Subsets
Medium
Topics
premium lock icon
Companies
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique. */
