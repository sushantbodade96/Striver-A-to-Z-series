
import java.util.HashMap;
import java.util.Map;

class longestHarmoniusSubSeq {

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int maxLen = 0;
        for (int num : freq.keySet()) {
            if (freq.containsKey(num + 1)) {
                int curLen = freq.get(num) + freq.get(num + 1);
                maxLen = Math.max(maxLen, curLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 2, 5, 4, 3, 3};
        System.out.println(findLHS(nums));
    }
}
