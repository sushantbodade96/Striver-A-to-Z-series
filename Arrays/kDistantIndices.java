//For every key, include all indices within k distance on both sides.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kDistantIndices {

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        int power = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                list.add(i);
                power = k;
            } else if (power > 0) {
                list.add(i);
                power--;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == key) {
                if (!list.contains(i)) {
                    list.add(i);
                }
                power = k;
            } else if (power > 0) {
                if (!list.contains(i)) {
                    list.add(i);
                }
                power--;
            }
        }

        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(findKDistantIndices(nums, 2, 2));
    }
}
