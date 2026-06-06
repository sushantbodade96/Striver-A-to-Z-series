
import java.util.*;

public class combinationSum {

    public static void allCombinations(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> list) {
        //
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }

        // //self include
        // sum += candidates[index];
        // list.add(candidates[index]);
        // allCombinations(candidates, index, sum, result, list, target);
        // list.remove(Integer.valueOf(candidates[index]));
        // //self exclude and and next exclude
        // sum -= candidates[index];
        // allCombinations(candidates, index + 1, sum, result, list, target);
        // //self exclude and next include
        // sum += candidates[index];
        // list.add(candidates[index]);
        // allCombinations(candidates, index + 1, sum, result, list, target);
        // list.remove(Integer.valueOf(candidates[index]));
        // Include current element
        list.add(candidates[index]);
        allCombinations(candidates, index, target - candidates[index], result, list);
        list.remove(list.size() - 1); // Backtrack

        // Exclude list element
        allCombinations(candidates, index + 1, target, result, list);
    }

    public static List<List<Integer>> combinations(int candidates[], int target) {
        List<List<Integer>> result = new ArrayList<>();
        allCombinations(candidates, 0, target, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 6, 7};
        System.out.println(combinations(nums, 7));
    }
}
/*39. Combination Sum
Medium
Topics
premium lock icon
Companies
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40 */
