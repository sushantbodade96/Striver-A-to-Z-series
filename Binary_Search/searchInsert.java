
public class searchInsert {

    //It is nothing but lower bound problem same as before
    public static int search_Insert(int[] nums, int target) {
        int n = nums.length;
        int right = n - 1;
        int left = 0;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] >= target) {
                n = mid;
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return n;

    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        System.out.println(search_Insert(nums, -1));
    }
}
