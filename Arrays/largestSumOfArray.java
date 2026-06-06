
public class largestSumOfArray {

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] < 0) {

            } else {
                if (nums[i] > 0) {
                    sum += nums[i];
                } else {
                    if (nums[i + 1] > nums[i]) {

                    }
                }
            }

        }

        return sum;
    }
}
