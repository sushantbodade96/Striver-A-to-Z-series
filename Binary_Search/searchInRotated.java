
public class searchInRotated {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) { //left part is sorted
                if (nums[left] <= target && target <= nums[mid]) { // target lies between left to mid
                    right = mid - 1;
                } else { // target lies between mid to right
                    left = mid + 1;
                }
            } else {// right part is sorted
                if (nums[mid] <= target && target <= nums[right]) {// target lies between mid to right
                    left = mid + 1;
                } else { // target lies between left to mid
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("The target 0 is present at index : " + search(nums, 0));
    }
}
