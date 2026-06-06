
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {

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
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            allCombinations(candidates, i + 1, target - candidates[i], result, list);
            list.remove(list.size() - 1); // Backtrack

            // Exclude list element
            //allCombinations(candidates, index + 1, target, result, list);
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        allCombinations(candidates, 0, target, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 2, 5, 3, 3, 1, 2};
        System.out.println(combinationSum2(nums, 5));
    }
}
