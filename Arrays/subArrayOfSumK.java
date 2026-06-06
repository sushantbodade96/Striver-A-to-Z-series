
import java.util.HashMap;

public class subArrayOfSumK {

    public static int subarraySum(int[] nums, int k) {
        int preSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int remove = preSum - k;
            count += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }

        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 3, -3, 6};
        System.out.println(subarraySum(arr, 3));
    }
}
