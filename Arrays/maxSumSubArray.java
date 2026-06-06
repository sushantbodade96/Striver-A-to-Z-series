
public class maxSumSubArray {

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            } else {
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, -6, 3, 7, -6, 2, -6, 9};
        System.out.println(maxSubArray(arr));
    }
}
