
public class lowerBound {

    //upper bound is same as this only difference is at line 12 nums[mid] > target (No equal is taken only greater)
    public static int LB(int nums[], int target) {
        int n = nums.length;
        int right = n - 1;
        int left = 0;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] >= target) {
                // n = mid;
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int nums[] = {3, 5, 8, 15, 19};
        System.out.println("The lower bound index for target " + 9 + " is : " + LB(nums, 9));
    }
}
