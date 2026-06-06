
import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {

    public static void helper(int index, int n, int k, List<Integer> list, List<List<Integer>> ans) {

        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index > 9 || n < 0 || k < 0) {
            return;
        }

        list.add(index);
        helper(index + 1, n - index, k - 1, list, ans);
        list.remove(list.size() - 1);

        helper(index + 1, n, k, list, ans);

    }

    public static List<List<Integer>> combinationSum3(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(7, 3));
    }
}
