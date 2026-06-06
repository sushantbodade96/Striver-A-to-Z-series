
import java.util.ArrayList;
import java.util.List;

public class powerSet {

    public static List<List<Integer>> allSubsets(int nums[]) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int subsets = 1 << n;
        for (int i = 0; i < subsets; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(allSubsets(nums));
    }
}
