
import java.util.Arrays;

public class smallestDivisor {

    public static int quotientSum(int nums[], int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // sum += Math.ceil((double) nums[i] / mid);
            sum += (nums[i] + mid - 1) / mid;
        }
        return sum;
    }

    public static int smallest_Divisor(int[] nums, int threshold) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        // System.out.println(right);
        if (nums.length == threshold) {
            return right;
        }
        //int ans = right;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;

            int quotient_sum = quotientSum(nums, mid);
            if (quotient_sum > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return left;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 5, 9};
        System.out.println("The smallest divisor is : " + smallest_Divisor(nums, 6));
    }
}
