
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class majorityElement2 {

    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        int required = n / 3;

        for (int i = 0; i < nums.length; i++) {
            // if (map.containsKey(nums[i])) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // } else {
            // map.put(nums[i], 1);
            //}

        }

        for (int key : map.keySet()) {
            if (map.get(key) > required) {
                list.add(key);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 1, 3, 3, 3, 3};
        System.out.println(majorityElement(nums));
    }
}
