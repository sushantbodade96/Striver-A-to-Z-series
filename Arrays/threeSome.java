
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSome {

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    List<Integer> tempList = Arrays.asList(nums[i], nums[j], nums[k]);
                    list.add(tempList);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                }
            }

        }

        return list;
    }

    public static void main(String[] args) {
        int nums[] = {1, -1, 2, -2, 0, 0, 0, -3};
        System.out.println(threeSum3(nums));
    }
}
